package co.istad.sb7springmvc.controller;

import co.istad.sb7springmvc.dto.CreateProductDto;
import co.istad.sb7springmvc.dto.UpdateProductDto;
import co.istad.sb7springmvc.model.Product;
import co.istad.sb7springmvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Integer id)
    {
        return productService.getProductById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewProduct(@RequestBody CreateProductDto createProductDto)
    {
        System.out.println(createProductDto.supplierId());
        System.out.println(createProductDto.categoryIds());
        productService.createNewProduct(createProductDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateProductById(@PathVariable Integer id,
                                  @RequestBody UpdateProductDto updateProductDto)
    {
        System.out.println(updateProductDto.supplier_id());
        System.out.println(updateProductDto.categoryIds());
        productService.updateProductById(id, updateProductDto);
    }
}
