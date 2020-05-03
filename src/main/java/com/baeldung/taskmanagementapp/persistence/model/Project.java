package com.baeldung.taskmanagementapp.persistence.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Project {

    private Long id;
    private String name;
    private LocalDate dateCreated;
    private String internalId;

    public Project(Long id, String name, LocalDate dateCreated) {
        if (Objects.isNull(id)) {
            id = new Random().nextLong();
        }
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public Project(Project project) {
        this(project.getId(), project.getName(), project.getDateCreated());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return getId().equals(project.getId()) &&
               getName().equals(project.getName()) &&
               getDateCreated().equals(project.getDateCreated());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName(), getDateCreated());
    }

    @Override public String toString() {
        return "Project{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", dateCreated=" + dateCreated +
               '}';
    }
}
