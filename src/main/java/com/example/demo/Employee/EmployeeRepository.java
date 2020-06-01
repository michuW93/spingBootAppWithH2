package com.example.demo.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByPesel(String pesel);

    List<Employee> findAll();

    @Query(
            value = "SELECT * FROM employees e where e.first_name = :firstName AND e.department_id = :department",
            nativeQuery=true
    )
    Employee findByFirstNameAndDepartment(String firstName, Long department);
}
