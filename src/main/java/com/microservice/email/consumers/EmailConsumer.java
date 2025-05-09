package com.microservice.email.consumers;

import com.microservice.email.dtos.EmailRecordDto;
import com.microservice.email.entities.Email;
import com.microservice.email.enums.StatusEmail;
import com.microservice.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer{

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService){
        this.emailService = emailService;
    }

    @RabbitListener(queues="${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){
        Email email = new Email();
        BeanUtils.copyProperties( emailRecordDto , email );

        emailService.sendEmail(email);//enviar de facto o email ao user cadastrado


    }

}
