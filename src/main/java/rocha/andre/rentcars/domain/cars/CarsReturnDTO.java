package rocha.andre.rentcars.domain.cars;


public record CarsReturnDTO(Long id, String manufacturer, String model, String year,
                            String color, Price price, Boolean available) {
    public CarsReturnDTO(Cars cars) {
        this(cars.getId(), cars.getManufacturer(), cars.getModel(), cars.getYear(),
                cars.getColor(), cars.getPrice(), cars.getAvailable());
    }
}
