package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class BaseModel {
    private Long id;
    private Date CreatedAt;

    private Date UpdatedAt;

    private boolean isDeleted;

}
