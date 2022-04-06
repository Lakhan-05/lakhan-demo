package com.product.service.request.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductServiceRequestMapper {

    ProductServiceRequestMapper PRODUCT_SERVICE_REQUEST_MAPPER= Mappers.getMapper(ProductServiceRequestMapper.class);

}
