package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetSingleProductResponseDto {
    private Product product;
}
