package rocha.andre.rentcars.domain.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarsRepository extends JpaRepository<Car, Long> {

    @Query("""
            SELECT c FROM Car c
            WHERE c.id = :id
            """)
    Car findByIdToHandle(Long id);
}
