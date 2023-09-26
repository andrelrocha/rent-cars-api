package rocha.andre.rentcars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocha.andre.rentcars.domain.driver.DriverDTO;
import rocha.andre.rentcars.domain.driver.DriverReturnDTO;
import rocha.andre.rentcars.domain.driver.UseCase.CreateDriverUseCase;
import rocha.andre.rentcars.service.DriversService;

@Service
public class DriversServiceImpl implements DriversService {
    @Autowired
    private CreateDriverUseCase createDriverUseCase;

    @Override
    public DriverReturnDTO createDriver(DriverDTO data) {
        var newDriver = createDriverUseCase.createDriver(data);
        return newDriver;
    }
}
