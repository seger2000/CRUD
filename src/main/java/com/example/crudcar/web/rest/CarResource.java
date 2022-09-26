package com.example.crudcar.web.rest;

import com.example.crudcar.service.CarService;
import com.example.crudcar.service.dto.CarDto;
import lombok.RequiredArgsConstructor;
import tech.jhipster.web.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarResource {

    private final CarService carService;


    @PostMapping("/car")
    public ResponseEntity<CarDto> create(@RequestBody CarDto carDto) {
        return new ResponseEntity<>(carService.create(carDto), HttpStatus.CREATED);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarDto> findById(@PathVariable(name = "id") Long id) {
        Optional<CarDto> carDto = carService.findById(id);
        return ResponseUtil.wrapOrNotFound(carDto);
    }

    @GetMapping("/car")
    public ResponseEntity<CarDto> findAll() {
        List<CarDto> carDtos = carService.findAll();
        return new ResponseEntity(carDtos, HttpStatus.OK);
    }

    @PutMapping("/car/update")
    public ResponseEntity<CarDto>updateCare(CarDto carDto) {
        return new ResponseEntity<>(carService.updateCar(carDto), HttpStatus.OK);
    }

    @DeleteMapping("/car/delete/{id}")
    public void deleteCar(@PathVariable(name = "id") Long id) { carService.deleteCar(id); }

    @GetMapping("/test")
    public String test(){return "test-car";}
}
