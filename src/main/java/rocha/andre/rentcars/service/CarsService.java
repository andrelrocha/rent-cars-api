package rocha.andre.rentcars.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rocha.andre.rentcars.domain.cars.CarDTO;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;

public interface CarsService {
    public CarReturnDTO createCar(CarDTO data);
    public Page<CarReturnDTO> getAllCars(Pageable pageable);
    public CarReturnDTO getCarById(Long id);
}
