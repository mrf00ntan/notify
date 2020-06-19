package kz.eserzhanov.microservice.notify.notify_microservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailNotifyRequestPOJO {
    private String email;
    private String subject;
    private String html;
}
