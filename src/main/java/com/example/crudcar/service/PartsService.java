package com.example.crudcar.service;

import com.example.crudcar.domain.PartsOfCar;
import com.example.crudcar.repository.PartsRepository;
import com.example.crudcar.service.dto.PartsOfCarDto;
import com.example.crudcar.service.mapper.PartsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartsService {

    private final PartsMapper partsMapper;

    private final PartsRepository partsRepository;


    public PartsOfCarDto create(PartsOfCarDto partsOfCarDto) {
        PartsOfCar partsOfCar = partsMapper.toEntity(partsOfCarDto);
        partsOfCar.setCreatedDate(new Date());
        return partsMapper.toDto(partsRepository.save(partsOfCar));
    }

    public Optional<PartsOfCarDto> findById(Long id) {
        return partsRepository.findById(id).map(partsMapper::toDto);
    }

    public List<PartsOfCarDto> findAllByIdCar(Long id) {
        List<PartsOfCar> partsOfCars = partsRepository.findAllByCarId(id);
        return partsMapper.toDto(partsOfCars);
    }

    public PartsOfCarDto update(PartsOfCarDto partsOfCarDto) {
        partsRepository.findById(partsOfCarDto.getCarId()).orElseThrow(() -> new IllegalStateException("Car with id = " +partsOfCarDto.getId() +"dose not exist"));
        PartsOfCar partsOfCar = partsMapper.toEntity(partsOfCarDto);
        return partsMapper.toDto(partsRepository.save(partsOfCar));
    }

    public void delete(Long id){
        partsRepository.findById(id).orElseThrow(() -> new IllegalStateException("Car with id = " + id +"dose not exist"));
        partsRepository.deleteById(id);
    }

}
