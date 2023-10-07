package com.scaler.productservice.inheritanceexamples.mappedsuperclass;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity(name = "mp_instructor")
public class Instructor extends User {
    private boolean isHandsome;
}
