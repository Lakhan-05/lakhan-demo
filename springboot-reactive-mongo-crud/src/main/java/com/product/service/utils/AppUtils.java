package com.product.service.utils;

import com.dto.ProductDto;
import com.product.service.entity.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {


    // method to convert entity class to dto class
    public static ProductDto entityToDto(Product product){

        ProductDto productDto=new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;

    }


    // method to convert dto class to entity class
    public static Product dtoToEntity(ProductDto productDto){

        Product product=new Product();
        BeanUtils.copyProperties(productDto,product); // we can use BeanUtils.copyProperties(),
        return product;                          //when source and destination objects have same attributes or member

    }


}
