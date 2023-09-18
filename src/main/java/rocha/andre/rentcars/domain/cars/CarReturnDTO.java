package rocha.andre.rentcars.domain.cars;


public record CarReturnDTO(Long id, String manufacturer, String model, String year,
                           String color, Price price, Boolean available) {
    public CarReturnDTO(Car car) {
        this(car.getId(), car.getManufacturer(), car.getModel(), car.getYear(),
                car.getColor(), car.getPrice(), car.getAvailable());
    }
}
