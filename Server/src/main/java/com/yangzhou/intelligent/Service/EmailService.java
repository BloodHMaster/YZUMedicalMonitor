package com.yangzhou.intelligent.Service;

public interface EmailService {
    void sendEmailVerCode(String receiver, String verCode);
}
