package rocha.andre.rentcars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocha.andre.rentcars.domain.users.UseCase.CreateUserUseCase;
import rocha.andre.rentcars.domain.users.UseCase.ForgotPasswordUseCase;
import rocha.andre.rentcars.domain.users.UseCase.PerformLoginUseCase;
import rocha.andre.rentcars.domain.users.UseCase.ResetPasswordUseCase;
import rocha.andre.rentcars.domain.users.UserDTO;
import rocha.andre.rentcars.domain.users.UserLoginDTO;
import rocha.andre.rentcars.domain.users.UserResetPassDTO;
import rocha.andre.rentcars.domain.users.UserReturnDTO;
import rocha.andre.rentcars.infra.security.TokenJwtDTO;
import rocha.andre.rentcars.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private PerformLoginUseCase performLoginUseCase;
    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private ForgotPasswordUseCase forgotPasswordUseCase;
    @Autowired
    private ResetPasswordUseCase resetPasswordUseCase;

    @Override
    public TokenJwtDTO performLogin(UserDTO data) {
        var tokenJWT = performLoginUseCase.performLogin(data);
        return tokenJWT;
    }

    @Override
    public UserReturnDTO createUser(UserDTO data) {
        var newUser = createUserUseCase.createUser(data);
        return newUser;
    }

    @Override
    public String forgotPassword(UserLoginDTO data) {
        forgotPasswordUseCase.forgotPassword(data);
        return "Email successfully sent!";
    }

    @Override
    public String resetPassword(UserResetPassDTO data) {
        resetPasswordUseCase.resetPassword(data);
        return "Password successfully updated!";
    }
}
