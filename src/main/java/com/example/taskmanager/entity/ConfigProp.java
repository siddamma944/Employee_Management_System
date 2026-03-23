package com.example.taskmanager.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProp {
    @Value("${app.name}")
    private String appnName;
    @Value("${app.version:1.0.0}")
    private String appVersion;
}
