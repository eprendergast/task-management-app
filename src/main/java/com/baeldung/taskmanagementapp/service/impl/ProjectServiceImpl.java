package com.baeldung.taskmanagementapp.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baeldung.taskmanagementapp.persistence.model.Project;
import com.baeldung.taskmanagementapp.persistence.repository.IProjectRepository;
import com.baeldung.taskmanagementapp.service.IProjectService;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        if (StringUtils.isEmpty(String.valueOf(project.getId()))) {
            project.setDateCreated(LocalDate.now());
        }
        return projectRepository.save(project);
    }

}