package com.baeldung.taskmanagementapp.persistence.repository.impl;

import java.time.LocalDate;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.baeldung.taskmanagementapp.persistence.model.Project;
import com.baeldung.taskmanagementapp.persistence.repository.IProjectRepository;

@Component
public class TestDataLoader implements ApplicationContextAware {

    @Autowired
    IProjectRepository projectRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        projectRepository.save(new Project(RandomString.make(6), LocalDate.now()));
        projectRepository.save(new Project(RandomString.make(6), LocalDate.now()));
        projectRepository.save(new Project(RandomString.make(6), LocalDate.now()));
        projectRepository.save(new Project(RandomString.make(6), LocalDate.now()));
    }


}
