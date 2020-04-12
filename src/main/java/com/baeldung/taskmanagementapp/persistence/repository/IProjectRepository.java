package com.baeldung.taskmanagementapp.persistence.repository;

import java.util.Optional;

import com.baeldung.taskmanagementapp.persistence.model.Project;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);

}
