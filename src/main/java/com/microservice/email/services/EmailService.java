package com.microservice.email.services;

import com.microservice.email.entities.Email;
import com.microservice.email.enums.StatusEmail;
import com.microservice.email.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String emailFrom;

    private final EmailRepository emailRepository;
    private JavaMailSender javaMailSender;

    public EmailService(EmailRepository emailRepository,JavaMailSender javaMailSender ){
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    @Transactional
    public void sendEmail(Email email){
        try{
            email.setEmailFrom(emailFrom);
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(emailFrom);
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getContent());

            email.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
        }finally {
            emailRepository.save( email );
            System.out.println("======================");
            System.out.println("   Email processado");
            System.out.println("======================");
        }
    }
}
