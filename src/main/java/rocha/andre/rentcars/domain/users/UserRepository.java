package rocha.andre.rentcars.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);

    @Query("""
            SELECT CASE WHEN COUNT(u) > 0 THEN true 
            ELSE false END 
            FROM User u WHERE u.login = :login
            """)
    boolean userExistsByLogin(String login);
}
