package rocha.andre.rentcars.domain.driver;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DriverDTO(String name,
                        @JsonFormat(pattern = "dd/MM/yyyy")
                        LocalDate birthday,
                        String cpf,
                        Long user_id ) {
}
