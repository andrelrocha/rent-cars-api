package rocha.andre.rentcars.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rocha.andre.rentcars.domain.cars.CarDTO;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.domain.cars.CarUpdateDTO;
import rocha.andre.rentcars.service.CarsService;

import java.net.URI;

@RestController
@RequestMapping("/cars")
@SecurityRequirement(name = "bearer-key")
public class CarsController {
    @Autowired
    private CarsService carsService;

    @GetMapping
    public ResponseEntity<Page<CarReturnDTO>> getAllCars(@PageableDefault(size = 5, sort = {"manufacturer"}) Pageable pageable) {
        var allCars = carsService.getAllCars(pageable);
        return ResponseEntity.ok(allCars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarReturnDTO> getCarById(@PathVariable Long id) {
        var car = carsService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CarReturnDTO> createCar(@RequestBody @Valid CarDTO data, UriComponentsBuilder uriBuilder) {
        var newCar = carsService.createCar(data);
        URI uri = uriBuilder.path("/cars/{id}").buildAndExpand(newCar.id()).toUri();
        return ResponseEntity.created(uri).body(newCar);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CarReturnDTO> updateCar(@RequestBody @Valid CarUpdateDTO data, @PathVariable Long id) {
        var updatedCar = carsService.updateCar(data, id);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCar(@PathVariable Long id) {
        carsService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
