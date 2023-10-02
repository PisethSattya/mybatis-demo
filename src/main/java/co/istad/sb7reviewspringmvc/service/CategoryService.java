package co.istad.sb7reviewspringmvc.service;

import co.istad.sb7reviewspringmvc.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> loadCategory();
    void addNewCategory(Category category);
    void updateCategoryById(Integer id,Category category);
    void deleteCategoryById(Integer id);
}
