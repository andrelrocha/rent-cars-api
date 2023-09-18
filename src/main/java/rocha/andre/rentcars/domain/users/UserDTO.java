package rocha.andre.rentcars.domain.users;

import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull
                      String login,
                      @NotNull
                      String password) { }
