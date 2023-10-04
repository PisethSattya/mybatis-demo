package co.istad.sb7springmvc.controller;


import co.istad.sb7springmvc.model.Category;
import co.istad.sb7springmvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Integer id)
    {
       return categoryService.getCategoryById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addNewCategory(@RequestBody Category category)
    {
        categoryService.addNewCategory(category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") Integer id)
    {
        categoryService.deleteCategoryById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateCategoryById(@PathVariable("id") Integer id,
                                   @RequestBody Category category)
    {
        categoryService.updateCategoryById(id, category);
    }
}
