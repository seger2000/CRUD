package com.example.crudcar.service.mapper;

import com.example.crudcar.domain.Car;
import com.example.crudcar.service.dto.CarDto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper extends EntityMapper<CarDto, Car>{

    @Override
    Car toEntity(CarDto dto);

    @Override

    CarDto toDto(Car entity);

    @Override
    List<Car> toEntity(List<CarDto> dtoList);

    @Override
    List<CarDto> toDto(List<Car> entityList);
}
