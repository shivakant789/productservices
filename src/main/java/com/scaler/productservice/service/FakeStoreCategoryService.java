package com.scaler.productservice.service;

import com.scaler.productservice.dtos.CategoryDto;
import com.scaler.productservice.dtos.ProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public List<String> getAllCategories() {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<String[]> l= restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );

        List<String> answer= new ArrayList<>();

        for (String str: l.getBody()) {
            answer.add(str);
        }
        return answer;
    }

    @Override
    public String getProductsInCategory(Long categoryId) {
        return null;
    }
}
