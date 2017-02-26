package com.fullstack.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by akjonca on 2/23/17.
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.fullstack.backend.persistence.repositories")
@EntityScan(basePackages = "com.fullstack.backend.persistence.domain.backend")
@PropertySource("file:///${user.home}/IdeaProjects16/dev1/fullstackproject/application-common.properties")
@EnableTransactionManagement
public class ApplicationConfig {
}
