package co.istad.sb7reviewspringmvc.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String slug;
    private Double price;
    private Boolean inStock;
    //defined relationship
   private Supplier supplier; // foreign key of Supplier table (many to one)
   private List<Category> categories; // (one to many)
}
