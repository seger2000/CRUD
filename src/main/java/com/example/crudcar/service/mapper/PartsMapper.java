package com.example.crudcar.service.mapper;

import com.example.crudcar.domain.PartsOfCar;
import com.example.crudcar.service.dto.PartsOfCarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PartsMapper extends EntityMapper<PartsOfCarDto, PartsOfCar> {
    @Override
    @Mapping(source = "carId", target = "car.id")
    @Mapping(target = "createdDate", ignore = true)
    PartsOfCar toEntity(PartsOfCarDto dto);

    @Override
    @Mapping(source = "car.id", target = "carId")
    PartsOfCarDto toDto(PartsOfCar entity);

    @Override
    List<PartsOfCar> toEntity(List<PartsOfCarDto> dtoList);

    @Override
    List<PartsOfCarDto> toDto(List<PartsOfCar> entityList);
}

