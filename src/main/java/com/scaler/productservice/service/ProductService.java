package com.scaler.productservice.service;

import com.scaler.productservice.dtos.ProductDto;
import com.scaler.productservice.dtos.ProductResponseDto;
import com.scaler.productservice.exceptions.NotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product>  getAllProducts();

    Optional<Product> getSingleProduct(Long productId) throws NotFoundException;

    Product addNewProduct(ProductDto product);
    Product updateProduct(Long productId,Product product);

    Product replaceProduct(Long productId,Product product);

    Optional<Product> deleteProduct(Long productId) throws NotFoundException;
}
