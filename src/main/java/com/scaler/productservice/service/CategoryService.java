package com.scaler.productservice.service;

import com.scaler.productservice.dtos.CategoryDto;
import com.scaler.productservice.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CategoryService {

    List<String> getAllCategories();

    String getProductsInCategory(Long categoryId);
}
