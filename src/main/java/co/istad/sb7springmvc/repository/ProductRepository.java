package co.istad.sb7springmvc.repository;

import co.istad.sb7springmvc.model.Product;
import co.istad.sb7springmvc.repository.provider.ProductProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductRepository {

    @Results(id = "ProductResultMap",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "inStock",column = "in_stock"),
            @Result(property = "supplier",column = "supplier_id", //foreign key
            one = @One(select = "co.istad.sb7springmvc.repository.SupplierRepository.selectProductSupplier")),

            @Result(property = "categories",column = "id",
            many = @Many(select = "co.istad.sb7springmvc.repository.CategoryRepository.selectProductCategory"))

    })
    @Select("SELECT * FROM products ORDER BY id DESC")
    List<Product> select();

    @ResultMap("ProductResultMap")
    @Select("SELECT * FROM products WHERE id = #{id}")
    Product selectById(@Param("id") Integer id);

    @InsertProvider(ProductProvider.class)
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    void insert(@Param("p") Product product);

    @InsertProvider(ProductProvider.class)
    void insertProductCategory(@Param("proId") Integer productId,
                               @Param("cateId") Integer categoryId);

    @UpdateProvider(ProductProvider.class)
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    void update(@Param("p") Product product);

    @Delete("DELETE FROM product_categories WHERE product_id = #{proId}")
    void deleteProductCategories(@Param("proId") Integer productId);
}
