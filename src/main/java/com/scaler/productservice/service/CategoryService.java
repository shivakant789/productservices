package com.scaler.productservice.service;

import com.scaler.productservice.dtos.CategoryDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CategoryService {

    List<Category> getAllCategories();

    List<Product> getProductsInCategory(String category);
}
