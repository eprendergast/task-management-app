package com.baeldung.taskmanagementapp;

import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.taskmanagementapp.persistence.model.Project;
import com.baeldung.taskmanagementapp.service.IProjectService;

@SpringBootApplication
public class App {

    @Autowired
    IProjectService projectService;

    public static void main(final String... args) {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        Project project = new Project(1L, "My First Project", LocalDate.now());
        projectService.save(project);

        Optional<Project> optionalProject = projectService.findById(1L);
        optionalProject.ifPresent(System.out::println);
    }

}
