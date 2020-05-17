package com.baeldung.taskmanagementapp.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.baeldung.taskmanagementapp.persistence.model.Task;

public interface ITaskRepository extends CrudRepository<Task, Long> {
}
