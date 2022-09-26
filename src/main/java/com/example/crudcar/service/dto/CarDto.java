package com.example.crudcar.service.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class CarDto {

    private Long id;

    @NonNull
    @Size(min = 3, max = 8)
    private String name;

    @NonNull
    @Size(min = 3, max = 12)
    private String model;

    @NonNull
    @Size(min =17 , max = 17)
    private String vinCode;

    private Date createdDate;

    private Date updateDate;


}
