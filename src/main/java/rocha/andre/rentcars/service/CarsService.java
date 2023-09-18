package rocha.andre.rentcars.service;

import rocha.andre.rentcars.domain.cars.CarDTO;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;

public interface CarsService {
    public CarReturnDTO createCar(CarDTO data);
}
