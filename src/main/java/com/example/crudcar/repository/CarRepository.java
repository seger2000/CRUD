package com.example.crudcar.repository;

import com.example.crudcar.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {

}
