package com.product.service.request.mapper;

import com.dto.ProductDto;
import com.product.service.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductServiceRequestMapper {

    ProductDto entityToDto(Product product);
    Product dtoToEntity(ProductDto productDto);
}
