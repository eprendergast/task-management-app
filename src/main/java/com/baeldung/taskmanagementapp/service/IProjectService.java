package com.baeldung.taskmanagementapp.service;

import java.util.Optional;

import com.baeldung.taskmanagementapp.persistence.model.Project;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);

}
