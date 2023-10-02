package co.istad.sb7reviewspringmvc.service.impl;

import co.istad.sb7reviewspringmvc.model.Category;
import co.istad.sb7reviewspringmvc.repository.CategoryRepository;
import co.istad.sb7reviewspringmvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> loadCategory() {
        return categoryRepository.select();
    }

    @Override
    public void addNewCategory(Category category) {
        category.setDescription(category.getName());
        categoryRepository.insert(category);
    }

    @Override
    public void updateCategoryById(Integer id, Category category) {
        category.setId(id);
        category.setDescription(category.getName());
        categoryRepository.update(category);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.delete(id);
    }
}
