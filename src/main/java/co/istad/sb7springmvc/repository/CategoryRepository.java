package co.istad.sb7springmvc.repository;

import co.istad.sb7springmvc.model.Category;
import co.istad.sb7springmvc.repository.provider.CategoryProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryRepository {

    @SelectProvider(CategoryProvider.class)
    List<Category> selectProductCategory(@Param("id")Integer id);

    @Select("SELECT * FROM categories ORDER BY id DESC")
    List<Category> select();
    @Select("SELECT * FROM categories WHERE id = #{id}")
    Category selectById(@Param("id") Integer id);
    @Insert("""
            INSERT INTO categories (name, description)
            VALUES (#{c.name}, #{c.description})
            """)
    void insert(@Param("c") Category category);

    @Delete("""
            DELETE FROM categories WHERE id = #{id}
            """)
    void delete(@Param("id") Integer id);

    @Update("""
            UPDATE categories
            SET name = #{c.name},
                description = #{c.description}
            WHERE id = #{c.id}
            """)
    void update(@Param("c") Category category);
}
