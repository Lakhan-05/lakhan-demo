package com.product.service.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dto.ProductDto;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductServiceResource {

    private Logger logger= LoggerFactory.getLogger(ProductServiceResource.class);

    @Autowired
    private ProductService service;


    @GetMapping
    public Flux<ProductDto> getProducts() {

        logger.info("** getProducts() called **");
        return service.getProducts();
    }


    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id) {

        logger.info("** getProduct() called **");
        return service.getProduct(id);
    }


    @GetMapping("/product-range")
    public Flux<ProductDto> getProductBetweenRange(@RequestParam("min") double min, @RequestParam("max") double max) {

        logger.info("** getProductBetweenRange() called **");
        return service.getProductInRange(min, max);
    }


    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono) {

        logger.info("** saveProduct() called **");
        return service.saveProduct(productDtoMono);
    }


    @PutMapping("/update/{id}")
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono, @PathVariable String id) {

        logger.info("** saveProduct() called **");
        return service.updateProduct(productDtoMono, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){

        logger.info("** deleteProduct() called **");
        return service.deleteProduct(id);
    }
}