package co.istad.sb7reviewspringmvc.service.impl;

import co.istad.sb7reviewspringmvc.model.Product;
import co.istad.sb7reviewspringmvc.repository.ProductRepository;
import co.istad.sb7reviewspringmvc.service.ProductService;
import co.istad.sb7reviewspringmvc.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
//    public ProductServiceImpl() {
////        products = new ArrayList<>();
////
////        products.add(Product.builder()
////                .id(1)
////                .name("MSI Stealth 16 Studio A13VF -202KH")
////                .slug(SlugUtil.toSlug("MSI Stealth 16 Studio A13VF -202KH"))
////                .price(1999.0)
////                .inStock(true)
////                .build());
////        products.add(Product.builder()
////                .id(2)
////                .name("MSI Bravo 17 C7VF-026KH")
////                .slug(SlugUtil.toSlug("MSI Bravo 17 C7VF-026KH"))
////                .price(1199.0)
////                .inStock(true)
////                .build());
////        products.add(Product.builder()
////                .id(3)
////                .name("GF63 Thin 11UC-1613KH Black")
////                .slug(SlugUtil.toSlug("GF63 Thin 11UC-1613KH Black"))
////                .price(699.0)
////                .inStock(true)
////                .build());
////        products.add(Product.builder()
////                .id(4)
////                .name("ASUS TUF FA507XI-LP052W-2B")
////                .slug(SlugUtil.toSlug("ASUS TUF FA507XI-LP052W-2B"))
////                .price(1449.0)
////                .inStock(true)
////                .build());
////        products.add(Product.builder()
////                .id(5)
////                .name("ASUS ROG G834JZ-N6024W")
////                .slug(SlugUtil.toSlug("ASUS ROG G834JZ-N6024W"))
////                .price(2999.0)
////                .inStock(true)
////                .build());
////        products.add(Product.builder()
////                .id(6)
////                .name("ASUS ROG G614JV-N3217W")
////                .slug(SlugUtil.toSlug("ASUS ROG G614JV-N3217W"))
////                .price(1599.0)
////                .inStock(true)
////                .build());
////        products.add(Product.builder()
////                .id(7)
////                .name("Lenovo IdeaPad 3 15IAU7 - Artic Gray")
////                .slug(SlugUtil.toSlug("Lenovo IdeaPad 3 15IAU7 - Artic Gray"))
////                .price(599.0)
////                .inStock(true)
////                .build());
////    }
////
////    public List<Product> loadProducts()
////    {
////        return products;
////    }
////    public Product addProduct(Product product)
////    {
////        if (product != null)
////        {
////            product.setSlug(SlugUtil.toSlug(product.getName()));
////            products.add(product);
////            return product;
////        }
////        throw new RuntimeException("Product cannot added");
////    }
////    public Product updateProduct(Integer id, Product newProduct)
////    {
////      return products.stream()
////                .filter(product -> product.getId().equals(id))
////                .map(product -> {
////                    product.setName(newProduct.getName());
////                    product.setSlug(SlugUtil.toSlug(newProduct.getName()));
////                    product.setPrice(newProduct.getPrice());
////                    product.setInStock(newProduct.getInStock());
////                    return product;
////                })
////                .findFirst()
////                .orElseThrow();
////    }
////    public void deleteProduct(Integer id)
////    {
//////        Product identity = products.stream()
//////                .filter(product -> product.getId().equals(id))
//////                .findFirst()
//////                .orElseThrow(()->new RuntimeException("Invalid id"));
//////      return products.remove(identity);
////
////        products = products.stream()
////                .filter(product -> !product.getId().equals(id))
////               // .toList(); is immutable element . If delete cannot be added more element.....
////                .collect(Collectors.toList());
////    }
////    public Product loadProductById(Integer id)
////    {
////        return products.stream()
////                .filter(product -> product.getId().equals(id))
////                .findFirst()
////                .orElseThrow(
////                        ()->new RuntimeException("Product is not found.")
////                );
////    }
////
////    public List<Product> searchProduct(String name, Boolean status)
////    {
////        return products.stream()
////                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase())
////                        && product.getInStock().equals(status))
////                .toList();
////
////
//
//   }
    private final ProductRepository productRepository;
    @Override
    public void addNewProduct(Product product) {
        product.setInStock(true);
        product.setSlug(SlugUtil.toSlug(product.getName()));
        productRepository.insert(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public void updateProductById(Integer id, Product product) {
        product.setId(id);
        product.setSlug(SlugUtil.toSlug(product.getName()));
        product.setInStock(true);
        productRepository.update(product);
    }

    @Override
    public List<Product> loadProducts() {

        return productRepository.select();
    }

    @Override
    public Product loadProductById(Integer id) {
        return productRepository.selectById(id).orElseThrow();
    }
}
