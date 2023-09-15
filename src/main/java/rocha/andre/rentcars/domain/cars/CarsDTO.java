package rocha.andre.rentcars.domain.cars;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CarsDTO (
        @NotBlank
        String manufacturer,
        @NotBlank
        String model,
        @Pattern(regexp = "^(19|20)\\d{2}$")
        String year,
        @NotBlank
        String color,
        @NotNull
        Price price,
        Boolean available,
        Boolean active
) {}
