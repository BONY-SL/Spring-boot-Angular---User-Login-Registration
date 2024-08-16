package com.dilshan.login.Register.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_MIXED;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;

    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendUserCredentials(String to,
                                    String username,
                                    EmailTemplateName emailTemplate,
                                    String conformationUrl,
                                    String activationCode,
                                    String subject) throws MessagingException {

        String templateName;

        if(emailTemplate == null){
            templateName = "confirm-email";
        }else {
            templateName = emailTemplate.name();
        }

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                MULTIPART_MODE_MIXED,
                UTF_8.name()
        );

        Map<String ,Object> properties = new HashMap<>();

        properties.put("username",username);
        properties.put("confirmationUrl",conformationUrl);
        properties.put("activation_code",activationCode);


        Context context = new Context();
        context.setVariables(properties);

        helper.setFrom("usernamex1995@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);

        String template = templateEngine.process(templateName, context);

        helper.setText(template,true);

        emailSender.send(mimeMessage);

    }
}
