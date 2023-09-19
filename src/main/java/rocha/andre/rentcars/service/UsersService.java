package rocha.andre.rentcars.service;

import rocha.andre.rentcars.domain.users.UserDTO;
import rocha.andre.rentcars.domain.users.UserLoginDTO;
import rocha.andre.rentcars.domain.users.UserResetPassDTO;
import rocha.andre.rentcars.domain.users.UserReturnDTO;
import rocha.andre.rentcars.infra.security.TokenJwtDTO;
import rocha.andre.rentcars.infra.utils.mail.MailDTO;

public interface UsersService {
    TokenJwtDTO performLogin(UserDTO data);
    UserReturnDTO createUser(UserDTO data);
    String forgotPassword(UserLoginDTO data);
    String resetPassword(UserResetPassDTO data);
}
