package com.baeldung.taskmanagementapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.baeldung.taskmanagementapp.persistence.model.Task;

public interface ITaskRepository extends PagingAndSortingRepository<Task, Long> {

    @Query("select t from Task t where t.name like %?1%")
    List<Task> findByNameMatches(String name);

}
