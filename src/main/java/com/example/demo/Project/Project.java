package com.example.demo.Project;

import com.example.demo.Employee.Employee;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private long projectId;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "projects")
    private Collection<Employee> employees;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return projectId == project.projectId &&
                Objects.equals(name, project.name) &&
                Objects.equals(employees, project.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, name, employees);
    }

}
