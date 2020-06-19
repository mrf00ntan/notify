package kz.eserzhanov.microservice.notify.notify_microservice.service;

import kz.eserzhanov.microservice.notify.notify_microservice.pojo.EmailNotifyRequestPOJO;

import javax.mail.MessagingException;

public interface EmailNotifyService {
    void sendEmail(EmailNotifyRequestPOJO emailNotifyRequest) throws MessagingException;
}
