package rocha.andre.rentcars.infra.utils.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import rocha.andre.rentcars.infra.exceptions.EmailSendingException;

@Component
public class MailSenderMime {
    @Value("${spring.mail.username}")
    private String fromMail;

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendMail(MailDTO data) {
        try {
            var mimeMessage = javaMailSender.createMimeMessage();
            var mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);

            mimeMessageHelper.setFrom(fromMail);
            mimeMessageHelper.setTo(data.to());
            mimeMessageHelper.setSubject(data.subject());
            mimeMessageHelper.setText(data.Body());

            /*
            MultipartFile[] file

            for (int i = 0; i < data.file().length; i++) {
                var currentFile = data.file()[i];
                mimeMessageHelper.addAttachment(
                        currentFile.getOriginalFilename(),
                        new ByteArrayResource(currentFile.getBytes())
                );
            }
            */

            javaMailSender.send(mimeMessage);

            return "Email successfully sent";
        } catch (Exception e) {
            throw new EmailSendingException("Failed to send email", e);
        }
    }
}
