package com.fullstack.config;

import com.fullstack.backend.service.EmailService;
import com.fullstack.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by akjonca on 2/20/17.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/IdeaProjects16/dev/fullstackproject/application-prod.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService() {
        return  new SmtpEmailService();
    }
}
