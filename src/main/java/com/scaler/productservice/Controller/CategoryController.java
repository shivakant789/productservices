package com.scaler.productservice.Controller;

import com.scaler.productservice.dtos.CategoryDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products/categories")
public class CategoryController {

    private CategoryService categoryService;



    @GetMapping()
    public List<String> getAllCategories(){
        return categoryService.getAllCategories();
    }


    @GetMapping("/{categoryId}")
    public String getProductsInCategories(@PathVariable("categoryId") Long categoryId){
        return "Getting Products in categories";
    }
}
