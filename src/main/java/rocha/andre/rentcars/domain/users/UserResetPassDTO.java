package rocha.andre.rentcars.domain.users;

import jakarta.validation.constraints.NotNull;

public record UserResetPassDTO(
        @NotNull
        String login,
        @NotNull
        String password,
        @NotNull
        String tokenEmail
        ) {
}
