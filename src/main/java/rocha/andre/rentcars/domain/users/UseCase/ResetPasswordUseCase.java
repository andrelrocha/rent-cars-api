package rocha.andre.rentcars.domain.users.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.users.UserRepository;
import rocha.andre.rentcars.domain.users.UserResetPassDTO;
import rocha.andre.rentcars.infra.exceptions.ValidationException;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ResetPasswordUseCase {
    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void resetPassword(UserResetPassDTO data) {
        try {
            var userExists = repository.existsByLogin(data.login());

            if (!userExists) {
                throw new ValidationException("No user was found for the provided login");
            }

            var user = repository.findByLoginToHandle(data.login());
            var tokenEmail = user.getTokenEmail();
            var tokenExpiration = user.getTokenExpiration();
            var now = LocalDateTime.now();

            var tokenIsValid = tokenEmail.equals(data.tokenEmail()) && now.isBefore(tokenExpiration);

            if (tokenIsValid) {
                String encodedPassword = bCryptPasswordEncoder.encode(data.password());
                user.setPassword(encodedPassword);
            } else {
                throw new ValidationException("Invalid reset token key");
            }
        }
        catch (Exception e) {
            throw new ValidationException("Something has happened during the reset password process: " + e.getMessage());
        }
    }
}
