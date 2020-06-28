package com.example.demo.Department;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    long departmentId;

    @Column(name = "name")
    String name;
    @Column(name = "manager")
    String manager;
    @Column(name = "mascot")
    String mascot;

    public Department() {
    }

    public Department(long id) {
        this.departmentId = id;
    }

    public long getId() {
        return departmentId;
    }

    public void setId(long id) {
        this.departmentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId &&
                name.equals(that.name) &&
                manager.equals(that.manager) &&
                mascot.equals(that.mascot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, name, manager, mascot);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", mascot='" + mascot + '\'' +
                '}';
    }
}
