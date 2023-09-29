package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Product extends BaseModel{
   private String title;

   private double price;

   private String desciption;

   private Category category;

   private String imageUrl;

}
