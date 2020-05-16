package com.baeldung.taskmanagementapp.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.taskmanagementapp.persistence.model.Task;
import com.baeldung.taskmanagementapp.persistence.model.TaskStatus;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class TaskRepositoryIntegrationTest {

    @Autowired
    ITaskRepository taskRepository;

    @Test
    public void givenProjectCreated_thenFindByTaskNameMatchesSuccess() {
        Task task1 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now().plusDays(1), TaskStatus.LOW);
        Task task2 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now().plusDays(2), TaskStatus.LOW);
        Task task3 = new Task("High Priority Task", "High Priority Task", LocalDate.now().plusDays(3), TaskStatus.HIGH);
        Task task4 = new Task("High Priority Task", "High Priority Task", LocalDate.now().plusDays(4), TaskStatus.HIGH);

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);

        List<Task> retrievedTasks = taskRepository.findByNameMatches("High");
        assertThat(retrievedTasks).contains(task3, task4);
    }

}