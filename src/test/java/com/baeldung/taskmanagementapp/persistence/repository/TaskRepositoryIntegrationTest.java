package com.baeldung.taskmanagementapp.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TaskRepositoryIntegrationTest {

    @Autowired
    ITaskRepository taskRepository;

//    @Test
//    public void givenProjectCreated_thenFindByTaskNameMatchesSuccess() {
//        Task task1 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now().plusDays(1), TaskStatus.);
//        Task task2 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now().plusDays(2), TaskStatus.LOW);
//        Task task3 = new Task("High Priority Task", "High Priority Task", LocalDate.now().plusDays(3), TaskStatus.HIGH);
//        Task task4 = new Task("High Priority Task", "High Priority Task", LocalDate.now().plusDays(4), TaskStatus.HIGH);
//
//        taskRepository.save(task1);
//        taskRepository.save(task2);
//        taskRepository.save(task3);
//        taskRepository.save(task4);
//
//        List<Task> retrievedTasks = taskRepository.findByNameMatches("High");
//        assertThat(retrievedTasks).contains(task3, task4);
//    }

}