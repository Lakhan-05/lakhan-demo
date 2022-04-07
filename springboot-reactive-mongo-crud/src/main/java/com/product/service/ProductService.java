package com.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.product.service.utils.AppUtils;
import com.dto.ProductDto;
import com.product.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class ProductService {

    private Logger logger= LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repository;


    public Flux<ProductDto> getProducts() {

        logger.info("** getProducts() called **");
        return repository.findAll().map(AppUtils::entityToDto);
    }


    public Mono<ProductDto> getProduct(String id) {

        logger.info("** getProduct() called **");
        return repository.findById(id).map(AppUtils::entityToDto);
    }


    public Flux<ProductDto> getProductInRange(double min, double max) {

        logger.info("** getProductInRange() called **");
        return repository.findByPriceBetween(Range.closed(min, max));
    }


    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){

        logger.info("** saveProduct() called **");
           return productDtoMono.map(AppUtils::dtoToEntity)
                      .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }


    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,String id){

        logger.info("** updateProduct() called **");
       return repository.findById(id)
                .flatMap(p->productDtoMono.map(AppUtils::dtoToEntity))
                .doOnNext(e->e.setId(id))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }


    public Mono<Void> deleteProduct(String id){

        logger.info("** deleteProduct() called **");
      return repository.deleteById(id);
    }


}
