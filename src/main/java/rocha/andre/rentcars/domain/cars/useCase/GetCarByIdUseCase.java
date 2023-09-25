package rocha.andre.rentcars.domain.cars.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.domain.cars.CarsRepository;
import rocha.andre.rentcars.infra.exceptions.ValidationException;

@Component
public class GetCarByIdUseCase {
    @Autowired
    private CarsRepository repository;

    public CarReturnDTO getCarById(Long id) {
        var carExists = repository.existsById(id);

        if (!carExists) {
            throw new ValidationException("No car was found for the provided id");
        }

        var car = repository.findByIdToHandle(id);

        return new CarReturnDTO(car);
    }

}
