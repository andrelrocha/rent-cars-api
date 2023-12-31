package rocha.andre.rentcars.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rocha.andre.rentcars.domain.cars.CarDTO;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.domain.cars.CarUpdateDTO;

public interface CarsService {
    public CarReturnDTO createCar(CarDTO data);
    public Page<CarReturnDTO> getAllCars(Pageable pageable);
    public CarReturnDTO getCarById(Long id);
    public CarReturnDTO updateCar(CarUpdateDTO data, Long id);
    public void deleteCar(Long id);
}
