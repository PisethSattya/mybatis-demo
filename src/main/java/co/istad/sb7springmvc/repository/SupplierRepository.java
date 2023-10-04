package co.istad.sb7springmvc.repository;

import co.istad.sb7springmvc.model.Supplier;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupplierRepository {
    @Select("SELECT * FROM suppliers WHERE id = #{id}")
    Supplier selectProductSupplier(@Param("id") Integer id);

    @Select("SELECT * FROM suppliers ORDER BY id DESC")
    List<Supplier> select();
    @Select("SELECT * FROM suppliers WHERE id = #{id}")
    Supplier selectById(@Param("id") Integer id);

    @Insert("""
            INSERT INTO suppliers (company,since,status)
            VALUES (#{s.company},#{s.since},#{s.status})
            """)
    void insert(@Param("s") Supplier supplier);

    @Delete("""
            DELETE FROM suppliers WHERE id = #{id}
            """)
    void delete(@Param("id") Integer id);
    @Update("""
            UPDATE suppliers
            SET company = #{s.company},
                status = #{s.status}
            WHERE id = #{s.id}
            """)
    void update(@Param("s") Supplier supplier);
}
