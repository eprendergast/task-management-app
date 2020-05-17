package com.baeldung.taskmanagementapp.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.baeldung.taskmanagementapp.persistence.model.Project;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
