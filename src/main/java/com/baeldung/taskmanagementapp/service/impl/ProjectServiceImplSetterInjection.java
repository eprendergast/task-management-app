package com.baeldung.taskmanagementapp.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.baeldung.taskmanagementapp.persistence.model.Project;
import com.baeldung.taskmanagementapp.persistence.repository.IProjectRepository;
import com.baeldung.taskmanagementapp.service.IProjectService;

@Service
public class ProjectServiceImplSetterInjection implements IProjectService {

    private IProjectRepository projectRepository;

    // removed the constructor as it is no longer needed

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Autowired // marks the projectRepository bean to be injected
    @Qualifier("projectRepositoryImpl2") // @Qualifier points to the bean we want to inject, since there are multiple implementations
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}

