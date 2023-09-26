package rocha.andre.rentcars.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rocha.andre.rentcars.domain.driver.DriverDTO;
import rocha.andre.rentcars.domain.driver.DriverReturnDTO;
import rocha.andre.rentcars.service.DriversService;

@RestController
@RequestMapping("/drivers")
@SecurityRequirement(name = "bearer-key")
public class DriversController {
    @Autowired
    private DriversService driversService;

    @PostMapping
    @Transactional
    public ResponseEntity<DriverReturnDTO> createDriver(@RequestBody @Valid DriverDTO data, UriComponentsBuilder uriBuilder) {
        var newDriver = driversService.createDriver(data);
        var uri = uriBuilder.path("/drivers/{id}").buildAndExpand(newDriver.id()).toUri();
        return ResponseEntity.created(uri).body(newDriver);
    }
}
