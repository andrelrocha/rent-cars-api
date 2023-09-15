package rocha.andre.rentcars.domain.cars;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cars")
@Entity(name = "Car")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private String year;
    private String color;
    @Enumerated(EnumType.STRING)
    private Price price;
    private Boolean available;
    private Boolean active;

    public Cars(CarsDTO data) {
        this.manufacturer = data.manufacturer();
        this.model = data.model();
        this.year = data.year();
        this.color = data.color();
        this.price = data.price();
        this.available = data.available();
        this.active = data.active();
    }

    public void updateData(CarsDTO data) {
        if (data.color() != null) {
            this.color = data.color();
        }

        if (data.price() != null) {
            this.price = data.price();
        }

        if (data.available() != null) {
            this.available = data.available();
        }
    }

    public void exclude() {
        this.active = false;
    }

}
