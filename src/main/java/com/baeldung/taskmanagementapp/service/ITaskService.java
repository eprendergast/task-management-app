package com.baeldung.taskmanagementapp.service;

import java.util.Optional;

import com.baeldung.taskmanagementapp.persistence.model.Task;

public interface ITaskService {
    Optional<Task> findById(Long id);

    Task save(Task project);
}
