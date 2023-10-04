package com.scaler.productservice.clients.fakestoreapi;

import com.scaler.productservice.dtos.CategoryDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class FakeStoreCategoryClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<Category> getAllCategories() {
        RestTemplate restTemplate= restTemplateBuilder.build();
//        ResponseEntity<String[]> l= restTemplate.getForEntity(
//                "https://fakestoreapi.com/products/categories",
//                String[].class
//        );
//
//        List<String> answer= new ArrayList<>();
//
//        for (String str: l.getBody()) {
//            answer.add(str);
//        }
//        return answer;

        ResponseEntity<CategoryDto[]> l= restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                CategoryDto[].class
        );

        List<Category> answer= new ArrayList<>();

        for(CategoryDto categoryDto:l.getBody()){
            Category category= new Category();
            category.setName(categoryDto.getName());
            answer.add(category);
        }
        return answer;
    }


    public List<FakeStoreProductDto> getProductsInCategory(String category) {
        RestTemplate restTemplate= restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity= restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{category}",
                FakeStoreProductDto[].class,
                category
        );

        return Arrays.asList(fakeStoreProductDtoResponseEntity.getBody());


    }
}
