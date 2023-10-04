package co.istad.sb7springmvc.dto;

import java.util.List;

public record UpdateProductDto(String name,
                               Integer supplier_id,
                               List<Integer> categoryIds){
}
