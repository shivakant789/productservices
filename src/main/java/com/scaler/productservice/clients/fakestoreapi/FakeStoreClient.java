package com.scaler.productservice.clients.fakestoreapi;

import com.scaler.productservice.dtos.ProductDto;
import com.scaler.productservice.exceptions.NotFoundException;
import com.scaler.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;



    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l= restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
       return Arrays.asList(l.getBody());
    }

    public FakeStoreProductDto getSingleProduct(Long productId) throws NotFoundException {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response= restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class,productId);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();



        return fakeStoreProductDto;
    }

    FakeStoreProductDto addNewProduct(ProductDto product) {
        return null;
    }
    FakeStoreProductDto updateProduct(Long productId, Product product) {
        return null;
    }
    // if (product.getImageUrl() != null) {
    //
    // }
    FakeStoreProductDto replaceProduct(Long productId, Product product) {
        return null;
    }



    FakeStoreProductDto deleteProduct(Long productId) {
        return null;
    }
}
