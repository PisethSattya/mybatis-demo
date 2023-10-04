package co.istad.sb7springmvc.service;

import co.istad.sb7springmvc.model.Category;
import co.istad.sb7springmvc.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(Integer id);

    void addNewCategory(Category category);

    void deleteCategoryById(Integer id);

    void updateCategoryById(Integer id, Category category);
}
