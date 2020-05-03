package com.baeldung.taskmanagementapp.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.baeldung.taskmanagementapp.persistence.model.Project;
import com.baeldung.taskmanagementapp.spring.TestConfig;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringJUnitConfig(classes = TestConfig.class) // makes this a Spring enabled test
public class ContextIntegrationTest {

    @Autowired
    IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project savedProject = projectService.save(new Project(1L, "name", LocalDate.now()));
        projectService.save(savedProject);

        assertThat(savedProject, is(notNullValue()));
    }



}
