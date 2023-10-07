package com.scaler.productservice.repositries;

import com.scaler.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product save(Product product);
}
