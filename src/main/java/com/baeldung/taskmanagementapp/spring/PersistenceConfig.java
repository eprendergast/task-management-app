package com.baeldung.taskmanagementapp.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.baeldung.taskmanagementapp.persistence.repository.impl.ProjectRepositoryImpl;

@Configuration
public class PersistenceConfig {

    @Bean // bean will be named projectRepository (after name of meethod)
    @Lazy(value = true) // allows the bean to be loaded when it is called, not at application start
    public ProjectRepositoryImpl projectRepository() {
        return new ProjectRepositoryImpl();
    }


}
