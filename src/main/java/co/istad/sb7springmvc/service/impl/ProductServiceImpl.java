package co.istad.sb7springmvc.service.impl;

import co.istad.sb7springmvc.dto.CreateProductDto;
import co.istad.sb7springmvc.dto.UpdateProductDto;
import co.istad.sb7springmvc.mapper.ProductMapper;
import co.istad.sb7springmvc.model.Category;
import co.istad.sb7springmvc.model.Product;
import co.istad.sb7springmvc.model.Supplier;
import co.istad.sb7springmvc.repository.ProductRepository;
import co.istad.sb7springmvc.service.ProductService;
import co.istad.sb7springmvc.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public List<Product> getProducts() {
        return productRepository.select();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.selectById(id);
    }

    @Transactional
    @Override
    public void createNewProduct(CreateProductDto createProductDto) {
        // Map DTO to POJO
//        Product product = Product.builder()
//                .name(createProductDto.name())
//                .slug(SlugUtil.toSlug(createProductDto.name()))
//                .price(createProductDto.price())
//                .inStock(createProductDto.inStock())
//                .supplier(Supplier.builder()
//                        .id(createProductDto.supplierId())
//                        .build())
//                .build();
        Product product = productMapper.fromCreateProductDto(createProductDto);
        product.setSlug(SlugUtil.toSlug(createProductDto.name()));

        // Start inserting a product
        productRepository.insert(product);

        System.out.println("INSERT PRODUCT ID: "+product.getId());

        //Start inserting a product category
        createProductDto.categoryIds().forEach(id->
                productRepository.insertProductCategory(product.getId(),id));
    }

    @Transactional
    @Override
    public void updateProductById(Integer id, UpdateProductDto updateProductDto) {
        // Map DTO to POJO
//        Product product = Product.builder()
//                .id(id)
//                .name(updateProductDto.name())
//                .supplier(Supplier.builder()
//                        .id(updateProductDto.supplier_id())
//                        .build())
//                .build();
        Product product = productMapper.fromUpdateProductDto(updateProductDto);

        product.setId(id);
        if (product.getName() != null)
        {
            product.setSlug(SlugUtil.toSlug(updateProductDto.name()));
        }

        // Start updating a product
        productRepository.update(product);
        System.out.println("UPDATE PRODUCT ID: "+product.getId());

        // Reset product category
        productRepository.deleteProductCategories(product.getId());

        // Start updating a product category
        updateProductDto.categoryIds().forEach(cate_Ids->
                productRepository.insertProductCategory(product.getId(),cate_Ids));
    }
}
