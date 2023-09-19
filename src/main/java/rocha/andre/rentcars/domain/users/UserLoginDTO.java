package rocha.andre.rentcars.domain.users;

import jakarta.validation.constraints.NotNull;

public record UserLoginDTO(
        @NotNull
        String login) {
}
