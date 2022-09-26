package com.example.crudcar.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "parts_of_car")
public class PartsOfCar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private String series;

    @Column(name = "price")
    private String price;

    @Column(name = "created_date")
    private Date createdDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
