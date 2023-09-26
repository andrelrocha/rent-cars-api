package rocha.andre.rentcars.domain.driver;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import rocha.andre.rentcars.domain.users.User;

import java.time.LocalDate;

@Table(name = "drivers")
@Entity(name = "Driver")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve seguir o formato 999.999.999-99")
    private String cpf;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Driver(DriverDTO data) {
        this.name = data.name();
        this.birthday = data.birthday();
        this.cpf = data.cpf();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
