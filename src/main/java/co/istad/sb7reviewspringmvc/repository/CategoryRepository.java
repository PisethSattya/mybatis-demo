package co.istad.sb7reviewspringmvc.repository;

import co.istad.sb7reviewspringmvc.model.Category;
import co.istad.sb7reviewspringmvc.repository.provider.CategoryProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryRepository {

    @SelectProvider(CategoryProvider.class)
    List<Category> selectProductCategory(@Param("product_id") Integer product_id);

    @Select("SELECT * FROM categories")
    List<Category> select();
    @Insert("""
            INSERT INTO categories (name, description)
            VALUES (#{c.name}, #{c.description})
            """)
    void insert(@Param("c") Category category);

    @Update("""
            UPDATE categories
            SET name = #{c.name},
                description = #{c.description}
            WHERE id = #{c.id}
            """)
    void update(@Param("c") Category category);

    @Delete("DELETE FROM categories WHERE id = #{id}")
    void delete(@Param("id") Integer id);
}
