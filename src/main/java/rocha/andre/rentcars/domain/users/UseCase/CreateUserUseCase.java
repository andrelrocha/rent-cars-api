package rocha.andre.rentcars.domain.users.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.users.*;
import rocha.andre.rentcars.infra.exceptions.ValidationException;

@Component
public class CreateUserUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserReturnDTO createUser(UserDTO data) {
        boolean userExists = userRepository.existsByLogin(data.login());

        if (userExists) {
            throw new ValidationException("Email or user creation already exists in our database");
        }

        User newUser = new User(data);
        String encodedPassword = bCryptPasswordEncoder.encode(data.password());
        newUser.setPassword(encodedPassword);

        userRepository.save(newUser);

        return new UserReturnDTO(newUser);
    }
}
