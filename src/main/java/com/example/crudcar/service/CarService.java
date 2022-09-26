package com.example.crudcar.service;

import com.example.crudcar.domain.Car;
import com.example.crudcar.repository.CarRepository;
import com.example.crudcar.service.dto.CarDto;
import com.example.crudcar.service.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final CarMapper carMapper;

    public CarDto create(CarDto CarDto){
        Car car = carMapper.toEntity(CarDto);
        car.setCreatedData(new Date());
        return carMapper.toDto(carRepository.save(car));
    }

    public Optional<CarDto> findById(Long id){
            return carRepository.findById(id).map(carMapper::toDto);
    }

    public List<CarDto>findAll(){
        List<Car> cars = carRepository.findAll();
        return carMapper.toDto(cars);
    }


    public CarDto updateCar(CarDto carDto) {
        carRepository.findById(carDto.getId()).orElseThrow(() ->
                new IllegalStateException("Car with id = " +carDto.getId() +"dose not exist"));
        Car car = carMapper.toEntity(carDto);
        car.setUpdateDate(new Date());
        return carMapper.toDto(carRepository.save(car));
    }

    public void deleteCar(Long id){
        carRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Car with id = " + id +"dose not exist"));
        carRepository.deleteById(id);
    }
}
