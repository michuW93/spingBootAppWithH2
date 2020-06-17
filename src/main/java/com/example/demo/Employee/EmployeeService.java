package com.example.demo.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findByPesel(String pesel);

    List<Employee> findAll();

    Employee findByFirstnameAndDepartment(String firstName);

    void findAllEmployees();

    void createEmployee(String firstName, String pesel, long departmentId);

    void removeEmployee(long employeeId);

    Employee changeEmployeeName(long id, String firstName);

    Employee findEmployeeById(long id);
}
