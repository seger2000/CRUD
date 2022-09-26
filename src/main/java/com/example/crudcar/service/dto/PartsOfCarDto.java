package com.example.crudcar.service.dto;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class PartsOfCarDto {

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String series;

    @NonNull
    private String price;

    private Date createdDate;

    private Long carId;

}
