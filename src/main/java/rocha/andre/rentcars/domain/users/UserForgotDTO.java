package rocha.andre.rentcars.domain.users;

import java.time.LocalDateTime;

public record UserForgotDTO(
        String tokenEmail,
        LocalDateTime tokenExpiration)
{ }

