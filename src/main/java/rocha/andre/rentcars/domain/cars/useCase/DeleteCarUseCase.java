package rocha.andre.rentcars.domain.cars.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.cars.CarsRepository;
import rocha.andre.rentcars.infra.exceptions.ValidationException;

@Component
public class DeleteCarUseCase {
    @Autowired
    private CarsRepository repository;

    public void deleteCar(Long id) {
        var carExists = repository.existsById(id);

        if (!carExists) {
            throw new ValidationException("No car was found for the provided id");
        }

        repository.deleteById(id);
    }
}
