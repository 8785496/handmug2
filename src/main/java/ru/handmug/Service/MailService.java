package ru.handmug.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail() throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("georg.88@mail.ru");
        mail.setFrom("mail@handmug.ru");
        mail.setSubject("Mail from Spring");
        mail.setText("Hello!");

        javaMailSender.send(mail);
    }
}
