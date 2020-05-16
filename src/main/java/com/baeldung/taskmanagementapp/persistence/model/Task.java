package com.baeldung.taskmanagementapp.persistence.model;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private LocalDate dateCreated;

    private LocalDate dueDate;

    private TaskStatus status;

    public Task(String name, String description, LocalDate dueDate, TaskStatus status) {
        this.id = new Random().nextLong();
        this.name = name;
        this.description = description;
        this.dateCreated = LocalDate.now();
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task() {

    }
}
