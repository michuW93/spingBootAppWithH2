package com.example.demo.Employee;

import com.example.demo.Department.Department;
import com.example.demo.ParkingSpace.ParkingSpace;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue
    private long employee_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(unique = true)
    private String pesel;

    @NotNull
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "parking_space_id")
    private ParkingSpace parkingSpace;

    public Employee(){}

    public Employee(long employee_id, String firstName, String pesel, Department department, ParkingSpace parkingSpace) {
        this.employee_id = employee_id;
        this.firstName = firstName;
        this.pesel = pesel;
        this.department = department;
        this.parkingSpace = parkingSpace;
    }

    public Employee(String firstName, String pesel, Department department) {
        this.firstName = firstName;
        this.pesel = pesel;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return employee_id == employee.employee_id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(pesel, employee.pesel) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, firstName, pesel, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstName='" + firstName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", department=" + department.toString() +
                ", parkingSpace=" + parkingSpace.toString() +
                '}';
    }
}
