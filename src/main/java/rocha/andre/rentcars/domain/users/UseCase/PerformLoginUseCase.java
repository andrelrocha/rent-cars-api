package rocha.andre.rentcars.domain.users.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.users.User;
import rocha.andre.rentcars.domain.users.UserDTO;
import rocha.andre.rentcars.infra.security.TokenJwtDTO;
import rocha.andre.rentcars.infra.security.TokenService;

@Component
public class PerformLoginUseCase {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    TokenService tokenService;

    public TokenJwtDTO performLogin(UserDTO data) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        Authentication authentication = manager.authenticate(authenticationToken);
        User userAuthenticated = (User) authentication.getPrincipal();

        String tokenJwt = tokenService.generateJwtToken(userAuthenticated);

        return new TokenJwtDTO(tokenJwt);
    }

}
