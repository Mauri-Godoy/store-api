package com.mg.store.service;

public interface SmptService {

    void sendEmail(String to, String subject, String text);

}
