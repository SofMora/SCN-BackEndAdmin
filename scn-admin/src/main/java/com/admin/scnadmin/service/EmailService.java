package com.admin.scnadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender ;
    private JavaMailSender configureMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("sncsolucionesquetransforman1@gmail.com");
        mailSender.setPassword("rbzsiidcrtycigwe"); // Asegúrate de que sea la clave correcta

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.connectiontimeout", "5000");
        props.put("mail.smtp.timeout", "5000");
        props.put("mail.smtp.writetimeout", "5000");

        return mailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        this.mailSender = configureMailSender();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sncsolucionesquetransforman1@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            mailSender.send(message);
            System.out.println("Email sent successfully!");
        } catch (MailException e) {
            e.printStackTrace(); // Imprime el error completo
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}
