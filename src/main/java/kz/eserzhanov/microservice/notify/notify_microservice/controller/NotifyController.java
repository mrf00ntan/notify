package kz.eserzhanov.microservice.notify.notify_microservice.controller;

import kz.eserzhanov.microservice.notify.notify_microservice.pojo.EmailNotifyRequestPOJO;
import kz.eserzhanov.microservice.notify.notify_microservice.service.EmailNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping(value = "/api/notify")
public class NotifyController {
    private final EmailNotifyService emailNotifyService;

    @Autowired
    public NotifyController(EmailNotifyService emailNotifyService) {
        this.emailNotifyService = emailNotifyService;
    }

    @PostMapping(value = "/to-email")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void toEmail(@RequestBody EmailNotifyRequestPOJO request) throws MessagingException {
        emailNotifyService.sendEmail(request);
    }
}
