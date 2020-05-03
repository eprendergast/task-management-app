package com.baeldung.taskmanagementapp.service.impl;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.baeldung.taskmanagementapp.persistence.model.Project;
import com.baeldung.taskmanagementapp.persistence.repository.IProjectRepository;
import com.baeldung.taskmanagementapp.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    private IProjectRepository projectRepository2;

    @PostConstruct
    public void after() {

    }

    public ProjectServiceImpl(@Qualifier("projectRepositoryImpl2") IProjectRepository projectRepository) {
        this.projectRepository = projectRepository; // project repository is being injected through the ProjectServiceImpl constructor
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public IProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
