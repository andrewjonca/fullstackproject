package com.fullstack.config;

import com.fullstack.backend.service.EmailService;
import com.fullstack.backend.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by akjonca on 2/20/17.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/IdeaProjects16/dev1/fullstackproject/application-dev.properties")
public class DevelopmentConfig {

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }

}
