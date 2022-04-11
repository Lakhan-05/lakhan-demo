package com.product.service.service;

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

    @Autowired
    private ProductRepository repository;

    // This method will return the flux of Productdto, first of all , this repository.findall() will return me the
    //list of product which is the entity, then i just convert to EntitytoDto with the help of map().
    //GET api
    public Flux<ProductDto> getProducts() {
        return repository.findAll().map(AppUtils::entityToDto);
    }


    // This method will return me the single product object based on the ID.
    //here also method will return the dto class, becoz this is the actual coding standard, we no need to directly
    // play with our model or entity class, we always need to get a request and return the response with this dto class.
    //GET api
    public Mono<ProductDto> getProduct(String id) {
        return repository.findById(id).map(AppUtils::entityToDto);
    }


    //This method will return the product based on the price range.
    //GET api
    public Flux<ProductDto> getProductInRange(double min, double max) {
        return repository.findByPriceBetween(Range.closed(min, max));
    }


    //POST api
    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){

           return productDtoMono.map(AppUtils::dtoToEntity)
                      .flatMap(repository::insert) //one to many, we need to use flatmap.
                .map(AppUtils::entityToDto);       // If it is a single mapping, we can go with a map.
    }


    //UPDATE api
    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,String id){

       return repository.findById(id)
                .flatMap(p->productDtoMono.map(AppUtils::dtoToEntity))
                .doOnNext(e->e.setId(id))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }



     //DELETE api
    public Mono<Void> deleteProduct(String id){

      return repository.deleteById(id);
    }


}
