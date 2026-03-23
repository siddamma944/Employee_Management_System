package com.example.taskmanager.entity;

import com.zaxxer.hikari.util.Credentials;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail")
@Data
public class MailConfig {
    private String host;
    private int port;
    private Credentials credentials; // Can even handle nested objects!

    // Standard getters and setters are REQUIRED
}
