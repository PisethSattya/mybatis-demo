package co.istad.sb7springmvc.service;

import co.istad.sb7springmvc.dto.CreateProductDto;
import co.istad.sb7springmvc.dto.UpdateProductDto;
import co.istad.sb7springmvc.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer id);

    void createNewProduct(CreateProductDto createProductDto);

    void updateProductById(Integer id, UpdateProductDto updateProductDto);
}
