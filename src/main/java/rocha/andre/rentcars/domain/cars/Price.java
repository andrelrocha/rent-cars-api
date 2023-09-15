package rocha.andre.rentcars.domain.cars;

public enum Price {
    PRICE_50(50.00),
    PRICE_100(100.00),
    PRICE_150(150.00),
    PRICE_200(200.00);

    private final double value;

    Price(double value) {
        this.value = value;
    }
}
