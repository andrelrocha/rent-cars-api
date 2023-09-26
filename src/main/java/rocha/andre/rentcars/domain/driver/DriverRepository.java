package rocha.andre.rentcars.domain.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("""
            SELECT d FROM Driver d
            WHERE d.id = :id
            """)
    Driver findDriverByIdToHandle(Long id);

    @Query("""
            SELECT d FROM Driver d
            WHERE d.user.id = :user_id
            """)
    Driver findDriverByUserId(Long user_id);
}
