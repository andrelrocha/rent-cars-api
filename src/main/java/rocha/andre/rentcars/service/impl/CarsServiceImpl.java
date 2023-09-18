package rocha.andre.rentcars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocha.andre.rentcars.domain.cars.CarDTO;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.domain.cars.useCase.CreateCarUseCase;
import rocha.andre.rentcars.service.CarsService;

@Service
@Transactional
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CreateCarUseCase createCarUseCase;

    @Override
    public CarReturnDTO createCar(CarDTO data) {
        var newCar = createCarUseCase.createCar(data);
        return newCar;
    }
}
