package com.example.crudcar.repository;

import com.example.crudcar.domain.PartsOfCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartsRepository extends JpaRepository<PartsOfCar,Long> {
    List<PartsOfCar> findAllByCarId(Long id);
}
