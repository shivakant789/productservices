package com.scaler.productservice.service;

import com.scaler.productservice.clients.fakestoreapi.FakeStoreCategoryClient;
import com.scaler.productservice.clients.fakestoreapi.FakeStoreProductDto;
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

    private FakeStoreCategoryClient fakeStoreCategoryClient;

    public FakeStoreCategoryService(RestTemplateBuilder restTemplateBuilder,FakeStoreCategoryClient fakeStoreCategoryClient){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreCategoryClient=fakeStoreCategoryClient;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());

        return product;
    }
    @Override
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

    @Override
    public List<Product> getProductsInCategory(String category) {
        List<FakeStoreProductDto> fakeStoreProductDtos= fakeStoreCategoryClient.getProductsInCategory(category);

        List<Product> answer=new ArrayList<>();

        for(FakeStoreProductDto productDto:fakeStoreProductDtos){
            answer.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return answer;
    }
}
