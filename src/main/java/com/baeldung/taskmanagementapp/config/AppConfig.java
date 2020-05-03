package com.baeldung.taskmanagementapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean(initMethod = "initialize") // tells Spring to look for the initialize method in BeanB
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(destroyMethod = "destroy")
    public BeanC beanC() {
        return new BeanC();
    }

}
