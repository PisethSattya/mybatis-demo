package co.istad.sb7springmvc.mapper;

import co.istad.sb7springmvc.dto.CreateProductDto;
import co.istad.sb7springmvc.dto.UpdateProductDto;
import co.istad.sb7springmvc.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "supplierId",target = "supplier.id")
    Product fromCreateProductDto(CreateProductDto createProductDto);

    @Mapping(source = "supplier_id",target = "supplier.id")
    Product fromUpdateProductDto(UpdateProductDto updateProductDto);

}
