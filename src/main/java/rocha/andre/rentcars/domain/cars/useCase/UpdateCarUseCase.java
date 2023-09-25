package rocha.andre.rentcars.domain.cars.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.domain.cars.CarUpdateDTO;
import rocha.andre.rentcars.domain.cars.CarsRepository;
import rocha.andre.rentcars.domain.users.UserReturnDTO;
import rocha.andre.rentcars.infra.exceptions.ValidationException;

@Component
public class UpdateCarUseCase {
    @Autowired
    private CarsRepository repository;

    public CarReturnDTO updateCar(CarUpdateDTO data, Long id) {
        var car = repository.findByIdToHandle(id);

        if (car == null) {
            throw new ValidationException("No car was found for the provided id");
        }

        car.updateData(data);

        return new CarReturnDTO(car);
    }

}
