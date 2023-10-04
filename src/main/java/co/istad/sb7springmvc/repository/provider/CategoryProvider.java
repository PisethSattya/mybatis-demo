package co.istad.sb7springmvc.repository.provider;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

import java.awt.*;

public class CategoryProvider implements ProviderMethodResolver {
    public String selectProductCategory()
    {
        return new SQL(){{
            SELECT("*");
            FROM("categories as c");
            INNER_JOIN("product_categories as pc ON c.id = pc.category_id");
            WHERE("#{id} = pc.product_id");
        }}.toString();
    }
}
