package rocha.andre.rentcars.domain.cars.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.cars.CarReturnDTO;
import rocha.andre.rentcars.domain.cars.CarsRepository;

@Component
public class GetAllCarUseCase {
    @Autowired
    private CarsRepository repository;

    public Page<CarReturnDTO> getAllCars(Pageable pageable) {
        return repository.findAll(pageable).map(CarReturnDTO::new);
    }

}

