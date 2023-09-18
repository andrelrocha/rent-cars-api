package rocha.andre.rentcars.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rocha.andre.rentcars.domain.cars.CarDTO;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.service.CarsService;

import java.net.URI;

@RestController
@RequestMapping("/cars")
@SecurityRequirement(name = "bearer-key")
public class CarsController {
    @Autowired
    private CarsService carsService;

    @PostMapping
    @Transactional
    public ResponseEntity<CarReturnDTO> createCar(@RequestBody @Valid CarDTO data, UriComponentsBuilder uriBuilder) {
        var newCar = carsService.createCar(data);
        URI uri = uriBuilder.path("/cars/{id}").buildAndExpand(newCar.id()).toUri();
        return ResponseEntity.created(uri).body(newCar);
    }
}
