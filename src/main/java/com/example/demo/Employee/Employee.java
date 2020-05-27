package com.example.demo.Employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    @Column(unique = true)
    private String pesel;

    public Employee(){}

    public Employee(long id, String firstName){
        this.id = id;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(pesel, employee.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, pesel);
    }
}
