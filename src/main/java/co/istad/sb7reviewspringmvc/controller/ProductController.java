package co.istad.sb7reviewspringmvc.controller;

import co.istad.sb7reviewspringmvc.model.Product;
import co.istad.sb7reviewspringmvc.service.ProductService;
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
    public List<Product> loadProducts()
    {
        return productService.loadProducts();
    }
    @GetMapping("/{id}") // create PathVariable placeholder url -> ("/{var_name}")
    public Product loadProductById(@PathVariable("id") Integer proId)
    {
//        System.out.println("Product ID : "+ProId);
//        System.out.println("Product Slug : "+slug);
        return productService.loadProductById(proId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addNewProduct(@RequestBody Product product)
    {
//        Product newProduct = Product.builder()
//                .id(8)
//                .name("Legion Slim 5 16IRH8")
//                .price(1639.0)
//                .inStock(true)
//                .build();
         productService.addNewProduct(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}") // create path variable url placeholder
    public void updateProduct(@PathVariable Integer id,
                                 @RequestBody Product newProduct)
    {
//       Product modifyProduct = Product.builder()
//               .id(4)
//               .name("ASUS TUF FA507XI-LP052W-2B")
//               .price(1449.0)
//               .inStock(false)
//               .build();
         productService.updateProductById(id, newProduct);
    }

    @PatchMapping
    public String updateProductPartially()
    {
        return "Update product partially";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id)
    {
       // return productService.deleteProduct(id);
        productService.deleteProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(required = false,defaultValue = "") String name,
                                       @RequestParam(required = false,defaultValue = "true") Boolean status)
    {
        System.out.println("Name : "+name);
        System.out.println("Status : "+status);

      //  return productService.searchProduct(name,status);
        return null;
    }

}
