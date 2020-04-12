package com.baeldung.taskmanagementapp.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baeldung.taskmanagementapp.persistence.repository.impl.ProjectRepositoryImpl;

@Configuration
public class PersistenceConfig {

    @Bean
    public ProjectRepositoryImpl projectRepository() {
        return new ProjectRepositoryImpl();
    }


}
