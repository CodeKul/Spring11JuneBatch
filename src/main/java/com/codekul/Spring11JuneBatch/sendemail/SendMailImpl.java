package com.codekul.Spring11JuneBatch.sendemail;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendMailImpl implements SendMail{
    @Autowired
    private MailSender mailSender;

    private final String FROM = "codekul.madhuri@gmail.com";

    public String sendMail(String to,String subject,String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(FROM);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
        return "Mail Sent";
    }
}
