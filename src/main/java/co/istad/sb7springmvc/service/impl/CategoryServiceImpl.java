package co.istad.sb7springmvc.service.impl;

import co.istad.sb7springmvc.model.Category;
import co.istad.sb7springmvc.repository.CategoryRepository;
import co.istad.sb7springmvc.repository.SupplierRepository;
import co.istad.sb7springmvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getCategories() {
        return categoryRepository.select();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.selectById(id);
    }

    @Override
    public void addNewCategory(Category category) {
        category.setDescription(category.getName());
        categoryRepository.insert(category);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.delete(id);
    }

    @Override
    public void updateCategoryById(Integer id, Category category) {
        category.setId(id);
        category.setDescription(category.getName());
        categoryRepository.update(category);
    }
}
