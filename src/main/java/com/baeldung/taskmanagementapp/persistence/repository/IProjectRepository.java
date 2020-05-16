package com.baeldung.taskmanagementapp.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.baeldung.taskmanagementapp.persistence.model.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {

}
