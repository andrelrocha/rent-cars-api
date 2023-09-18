package rocha.andre.rentcars.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.users.User;
import rocha.andre.rentcars.domain.users.UserRepository;

@Component
public class AuthenticateUserWithValidJwt {
    @Autowired
    private UserRepository userRepository;

    public User findUserAuthenticated(String login) {
        return (User) userRepository.findByLogin(login);
    }
}