package com.baeldung.taskmanagementapp.persistence.repository.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.taskmanagementapp.persistence.model.Project;
import com.baeldung.taskmanagementapp.persistence.repository.IProjectRepository;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        assertThat(projectRepository.save(createNewProject()), is(notNullValue())) ;
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = createNewProject();
        projectRepository.save(newProject);
        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());
        assertEquals(newProject, retrievedProject.get());
    }

    private Project createNewProject() {
        return new Project(RandomString.make(6), LocalDate.now());
    }


}