package co.istad.sb7reviewspringmvc.repository;

import co.istad.sb7reviewspringmvc.model.Product;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Mapper // used this annotation for declare repository in MyBatis
@Repository // used this annotation for become Persistence Layer on SpringWeb MVC
public interface ProductRepository {

    /*          InLine SQL
     * 1. declare method if we declare we need to know return type
    ------------------- Return type -------------------
    * -> for SELECT (Query) have 2 return_type : PoJo , List PoJo.
    * -> for INSERT,DELETE,UPDATE (Transactions) have 3 return_type:
    *                -> void , In (it mean return row affected), boolean.
    * */
    @Results(id = "ProductResultMap",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "inStock",column = "in_stock"),
            @Result(property = "supplier",column = "supplier_id",
            one = @One(select = "co.istad.sb7reviewspringmvc.repository.SupplierRepository.selectProductSupplier")),
            @Result(property = "categories",column = "id",
            many = @Many(select = "co.istad.sb7reviewspringmvc.repository.CategoryRepository.selectProductCategory"))

    })
    @Select("SELECT * FROM products")
    List<Product> select();

    @ResultMap("ProductResultMap")
    @Select("SELECT * FROM products WHERE id = #{id}")
    Optional<Product> selectById(@Param("id") Integer id);

    @ResultMap("ProductResultMap")
    @Insert("""
            INSERT INTO products (name, slug, price, in_stock, supplier_id)
            VALUES (#{p.name}, #{p.slug}, #{p.price}, #{p.inStock}, #{p.supplier.id})
            """)
    void insert( @Param("p") Product product);

    @Update("""
            UPDATE products
            SET name = #{p.name},
                slug = #{p.slug},
                price = #{p.price},
                in_stock = #{p.inStock},
                supplier_id = #{p.supplier.id}
            WHERE id = #{p.id}
            """)
    void update(@Param("p") Product product);

    @Delete("""
            DELETE FROM products WHERE id = #{id}
            """)
    void delete(@Param("id") Integer id);
}
