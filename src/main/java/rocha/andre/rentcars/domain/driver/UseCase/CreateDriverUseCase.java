package rocha.andre.rentcars.domain.driver.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.driver.Driver;
import rocha.andre.rentcars.domain.driver.DriverDTO;
import rocha.andre.rentcars.domain.driver.DriverRepository;
import rocha.andre.rentcars.domain.driver.DriverReturnDTO;
import rocha.andre.rentcars.domain.users.UserRepository;

@Component
public class CreateDriverUseCase {
    @Autowired
    private DriverRepository repository;
    @Autowired
    private UserRepository userRepository;

    public DriverReturnDTO createDriver(DriverDTO data) {

        var driverExists = repository.findDriverByUserId(data.user_id());

        if (driverExists != null) {
            throw new RuntimeException("There's already a driver for the provided user id");
        }

        var user = userRepository.findById(data.user_id())
                .orElseThrow(() -> new RuntimeException("No user was found for the provided id"));

        var newDriver = new Driver(data);
        newDriver.setUser(user);

        repository.save(newDriver);

        return new DriverReturnDTO(newDriver);
    }
}
