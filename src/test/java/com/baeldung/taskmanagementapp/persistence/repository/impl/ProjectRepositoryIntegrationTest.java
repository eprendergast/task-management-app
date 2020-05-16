package com.baeldung.taskmanagementapp.persistence.repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.baeldung.taskmanagementapp.persistence.model.Project;
import com.baeldung.taskmanagementapp.persistence.repository.IProjectRepository;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        assertThat(projectRepository.save(createNewProject()), is(notNullValue()));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = createNewProject();
        projectRepository.save(newProject);
        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());
        assertEquals(newProject, retrievedProject.get());
    }

    @Test
    public void givenProject_whenFindByName_thenSuccess() {
        Project newProject = createNewProject();
        projectRepository.save(newProject);
        Optional<Project> retrievedProject = projectRepository.findByName(newProject.getName());
        assertEquals(newProject, retrievedProject.get());
    }

    @Test
    public void givenProjects_whenFindByDateCreated_thenSucess() {
        Project project1 = createNewProjectByDate(LocalDate.now().minusYears(1));
        projectRepository.save(project1);
        Project project2 = createNewProjectByDate(LocalDate.now().minusDays(7));
        projectRepository.save(project2);
        Project project3 = createNewProjectByDate(LocalDate.now().minusDays(1));
        projectRepository.save(project3);

        List<Project> retrievedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(10), LocalDate.now());

        assertThat(retrievedProjects, hasItems(project2, project3));
    }

    @Test
    public void givenDateCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2));
        assertThat(retrievedProjects.getContent(), hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindAllSort_thenSuccess() {
        List<Project> retrievedProjects = (List<Project>) projectRepository.findAll(Sort.by(Order.asc("name")));

        List<Project> sortedProjects = retrievedProjects.stream().sorted(Comparator.comparing(Project::getName)).collect(Collectors.toList());

        assertEquals(sortedProjects, retrievedProjects);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSort_thenSuccess() {
        Iterable<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Order.asc("name"))));

        List<Project> projectList = new ArrayList<>();
        retrievedProjects.forEach(projectList::add);

        assertThat(projectList, hasSize(2));
    }


    private Project createNewProject() {
        return new Project(RandomString.make(6), LocalDate.now());
    }

    private Project createNewProjectByDate(LocalDate date) {
        return new Project(RandomString.make(6), date);
    }


}