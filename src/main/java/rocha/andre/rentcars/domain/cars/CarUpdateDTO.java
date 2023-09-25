package rocha.andre.rentcars.domain.cars;

public record CarUpdateDTO(String color,
                           Price price,
                           Boolean available,
                           Long id) {
}
