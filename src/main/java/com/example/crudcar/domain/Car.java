package com.example.crudcar.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "vin_code",length = 17)
    private String vinCode;

    @Column(name = "created_date")
    private Date createdData;

    @Column(name = "updated_date")
    private Date updateDate;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PartsOfCar> partsOfCarList;

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
