package com.baeldung.taskmanagementapp.persistence.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.baeldung.taskmanagementapp.persistence.model.Project;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {

    Optional<Project> findByName(String name); // findBy<AttributeName> convention will allows Spring Data to create the method implementation for us

    List<Project> findByDateCreatedBetween(LocalDate from, LocalDate before);

}
