package rocha.andre.rentcars.domain.users.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.domain.users.UserForgotDTO;
import rocha.andre.rentcars.domain.users.UserLoginDTO;
import rocha.andre.rentcars.domain.users.UserRepository;
import rocha.andre.rentcars.infra.exceptions.ValidationException;
import rocha.andre.rentcars.infra.utils.mail.MailDTO;
import rocha.andre.rentcars.infra.utils.mail.MailSenderMime;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Component
public class ForgotPasswordUseCase {
    @Autowired
    private UserRepository repository;
    @Autowired
    private MailSenderMime mailSender;

    public void forgotPassword(UserLoginDTO data) {
        var login = data.login();
        var userExists = repository.existsByLogin(login);

        if (!userExists) {
            throw new ValidationException("No user was found for the provided login");
        }

        var token = generateEmailToken();
        var now = LocalDateTime.now().plusHours(1);
        var forgotDTO = new UserForgotDTO(token, now);

        var user = repository.findByLoginToHandle(login);
        user.forgotPassword(forgotDTO);

        var subject = "Forgot Password";

        var mailDTO = new MailDTO(subject, login, token);

        mailSender.sendMail(mailDTO);
    }

    public String generateEmailToken() {
        int tokenLength = 20;
        byte[] tokenBytes = new byte[tokenLength];

        // Cria uma instância do SecureRandom para gerar números aleatórios seguros
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(tokenBytes);

        // Converta os bytes para uma representação hexadecimal
        StringBuilder tokenBuilder = new StringBuilder();
        for (byte b : tokenBytes) {
            tokenBuilder.append(String.format("%02x", b));
        }

        String token = tokenBuilder.toString();
        return token;
    }
}
