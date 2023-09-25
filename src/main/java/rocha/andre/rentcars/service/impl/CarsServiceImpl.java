package rocha.andre.rentcars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocha.andre.rentcars.domain.cars.CarDTO;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.domain.cars.CarUpdateDTO;
import rocha.andre.rentcars.domain.cars.useCase.CreateCarUseCase;
import rocha.andre.rentcars.domain.cars.useCase.GetAllCarUseCase;
import rocha.andre.rentcars.domain.cars.useCase.GetCarByIdUseCase;
import rocha.andre.rentcars.domain.cars.useCase.UpdateCarUseCase;
import rocha.andre.rentcars.service.CarsService;

@Service
@Transactional
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CreateCarUseCase createCarUseCase;
    @Autowired
    private GetAllCarUseCase getAllCarUseCase;
    @Autowired
    private GetCarByIdUseCase getCarByIdUseCase;
    @Autowired
    private UpdateCarUseCase updateCarUseCase;

    @Override
    public CarReturnDTO createCar(CarDTO data) {
        var newCar = createCarUseCase.createCar(data);
        return newCar;
    }

    @Override
    public Page<CarReturnDTO> getAllCars(Pageable pageable) {
        var cars = getAllCarUseCase.getAllCars(pageable);
        return cars;
    }

    @Override
    public CarReturnDTO getCarById(Long id) {
        var car = getCarByIdUseCase.getCarById(id);
        return car;
    }

    @Override
    public CarReturnDTO updateCar(CarUpdateDTO data, Long id) {
        var updatedCar = updateCarUseCase.updateCar(data, id);
        return updatedCar;
    }
}
