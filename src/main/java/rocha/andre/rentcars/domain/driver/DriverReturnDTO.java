package rocha.andre.rentcars.domain.driver;

import rocha.andre.rentcars.domain.users.UserReturnDTO;

import java.time.LocalDate;

public record DriverReturnDTO(Long id, String name, LocalDate birthday, String cpf, UserReturnDTO user) {
    public DriverReturnDTO(Driver driver) {
        this(driver.getId(), driver.getName(), driver.getBirthday(), driver.getCpf(), new UserReturnDTO(driver.getUser()));
    }
}
