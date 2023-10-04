package co.istad.sb7springmvc.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product
{
    private Integer id;
    private String name;
    private String slug;
    private Double price;
    private Boolean inStock;
    // defined relationship in POJO
    private Supplier supplier; // map relation foreign key
    List<Category> categories; // many categories (foreign key)

}
