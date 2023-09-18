package rocha.andre.rentcars.domain.cars.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.cars.Car;
import rocha.andre.rentcars.domain.cars.CarDTO;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.domain.cars.CarsRepository;

@Component
public class CreateCarUseCase {
    @Autowired
    private CarsRepository carsRepository;

    public CarReturnDTO createCar(CarDTO data) {
        try {
            var newCar = new Car(data);
            carsRepository.save(newCar);
            return new CarReturnDTO(newCar);
        } catch (IllegalArgumentException err) {
            throw new IllegalArgumentException("An error happened while trying to create a new car register in the db.");
        }
    }
}
