package com.example.crudcar.web.rest;

import com.example.crudcar.service.PartsService;
import com.example.crudcar.service.dto.PartsOfCarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.ResponseUtil;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PartsResource {

    private final PartsService partsService;

    @PostMapping("/parts-of-car")
    public ResponseEntity<PartsOfCarDto> create(@RequestBody PartsOfCarDto partsOfCarDto) {
        return new ResponseEntity(partsService.create(partsOfCarDto), HttpStatus.CREATED);
    }

    @GetMapping("/parts-of-car/{id}")
    public ResponseEntity<PartsOfCarDto> findById(@PathVariable(name = "id") Long id) {
        Optional<PartsOfCarDto> partsOfCarDto = partsService.findById(id);
        return ResponseUtil.wrapOrNotFound(partsOfCarDto);
    }

    @GetMapping("/parts-of-car/id-car/{id}")
    public ResponseEntity<PartsOfCarDto> findAllByIdCar(@PathVariable(name = "id") Long id) {
        List<PartsOfCarDto> partsOfCarDtos = partsService.findAllByIdCar(id);
        return new ResponseEntity(partsOfCarDtos, HttpStatus.OK);
    }

}
