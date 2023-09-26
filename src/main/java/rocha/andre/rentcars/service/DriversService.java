package rocha.andre.rentcars.service;

import rocha.andre.rentcars.domain.driver.DriverDTO;
import rocha.andre.rentcars.domain.driver.DriverReturnDTO;

public interface DriversService {
    public DriverReturnDTO createDriver(DriverDTO data);
}
