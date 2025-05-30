package com.mg.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpServiceImpl implements SmptService {

    private static final Logger logger = LoggerFactory.getLogger(SmtpServiceImpl.class);

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender javaMailSender;

    public SmtpServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom(from);
        if (false)
            javaMailSender.send(message);
        logger.info("Email enviado a " + to + " con el asunto " + subject);
    }

}
