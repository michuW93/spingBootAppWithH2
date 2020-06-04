package com.example.demo.Employee;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private long employee_id;

    private String firstName;

    @Column(unique = true)
    private String pesel;

    @NotNull
    private Long department_id;

    public Employee(){}

    public Employee(long employee_id, String firstName, String pesel, Long department_id) {
        this.employee_id = employee_id;
        this.firstName = firstName;
        this.pesel = pesel;
        this.department_id = department_id;
    }

    public Employee(long employee_id, String firstName){
        this.employee_id = employee_id;
        this.firstName = firstName;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
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

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return employee_id == employee.employee_id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(pesel, employee.pesel) &&
                Objects.equals(department_id, employee.department_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, firstName, pesel, department_id);
    }
}
