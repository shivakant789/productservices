package com.scaler.productservice.inheritanceexamples.singleclass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity(name = "st_instructor")
@DiscriminatorValue(value = "2")
public class Instructor extends User {
    private boolean isHandsome;
}
