package com.example.demo.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findByPesel(String pesel);

    List<Employee> findAll();

    Employee findByFirstnameAndDepartment(String firstName, Long department);
}
