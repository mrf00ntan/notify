package kz.eserzhanov.microservice.notify.notify_microservice.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { MessagingException.class })
    protected ResponseEntity<Object> messagingExceptionHandle(MessagingException ex, WebRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("errorRu", "Ошибка при отправке письма");
        map.put("errorKz", "Хатты жіберу қатесі");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> runtimeExceptionHandle(RuntimeException ex, WebRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("errorRu", "Ошибка сервера");
        map.put("errorKz", "Сервер қатесі");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }
}
