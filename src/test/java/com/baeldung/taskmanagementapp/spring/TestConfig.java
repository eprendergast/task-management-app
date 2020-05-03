package com.baeldung.taskmanagementapp.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.baeldung.taskmanagementapp")
public class TestConfig {
}
