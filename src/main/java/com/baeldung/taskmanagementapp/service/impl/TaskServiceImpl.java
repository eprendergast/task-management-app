package com.baeldung.taskmanagementapp.service.impl;

import java.util.Optional;

import com.baeldung.taskmanagementapp.persistence.model.Task;
import com.baeldung.taskmanagementapp.persistence.repository.ITaskRepository;
import com.baeldung.taskmanagementapp.service.ITaskService;

public class TaskServiceImpl implements ITaskService {
    private ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task project) {
        return taskRepository.save(project);
    }
}
