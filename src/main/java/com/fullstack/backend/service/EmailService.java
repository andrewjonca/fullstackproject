package com.fullstack.backend.service;

import com.fullstack.web.domain.frontend.Feedback;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by akjonca on 2/20/17.
 */
public interface EmailService {

    public void sendFeedbackEmail(Feedback feedback);

    public void sendGenericEmailMessage(SimpleMailMessage message);

}
