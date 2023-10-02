package co.istad.sb7reviewspringmvc.service;

import co.istad.sb7reviewspringmvc.model.Product;

import java.util.List;

public interface ProductService {
    void addNewProduct(Product product);
    void deleteProductById(Integer id);
    void updateProductById(Integer id,Product product);

    List<Product> loadProducts();

    Product loadProductById(Integer id);

}
