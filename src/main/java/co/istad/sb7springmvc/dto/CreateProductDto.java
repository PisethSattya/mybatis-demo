package co.istad.sb7springmvc.dto;

import java.util.List;

public record CreateProductDto (String name,
                                Double price,
                                Boolean inStock,
                                Integer supplierId,
                                List<Integer> categoryIds) {

}
