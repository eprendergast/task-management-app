package com.baeldung.taskmanagementapp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.baeldung.taskmanagementapp.persistence.repository.IProjectRepository;
import com.baeldung.taskmanagementapp.persistence.repository.impl.ProjectRepositoryImpl;

@Configuration
public class ApplicationConfig {

    // Singleton bean scope creates a single instance of a bean and will be cached.
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // this is the default for all beans; can also remove this annotation
    public IProjectRepository singletonBean() {
        return new ProjectRepositoryImpl();
    }

    // Prototype bean scope creates a new instance every time its requested
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public IProjectRepository prototypeBean() {
//        return new ProjectRepositoryImpl();
//    }

}
