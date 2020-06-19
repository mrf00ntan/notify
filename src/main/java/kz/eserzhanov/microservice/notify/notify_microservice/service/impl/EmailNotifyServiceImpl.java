package kz.eserzhanov.microservice.notify.notify_microservice.service.impl;

import kz.eserzhanov.microservice.notify.notify_microservice.pojo.EmailNotifyRequestPOJO;
import kz.eserzhanov.microservice.notify.notify_microservice.service.EmailNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailNotifyServiceImpl implements EmailNotifyService {
    private final JavaMailSender emailSender;

    @Autowired
    public EmailNotifyServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendEmail(EmailNotifyRequestPOJO emailNotifyRequest) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(emailNotifyRequest.getEmail());
        helper.setSubject(emailNotifyRequest.getSubject());
        helper.setText(emailNotifyRequest.getHtml(), true);
        emailSender.send(message);
    }
}
