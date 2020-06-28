package com.example.demo;

import com.example.demo.Department.Department;
import com.example.demo.Employee.Employee;
import com.example.demo.Employee.EmployeeServiceImpl;
import com.example.demo.ParkingSpace.ParkingSpace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class DemoWithH2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoWithH2Application.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(null, em);
        employeeService.createEmployee("Michal", "930818", new Department(1L));

        Employee employee1 = employeeService.findEmployeeById(1L);
        employeeService.removeEmployee(employee1.getEmployee_id());

        Employee removedEmployee = em.find(Employee.class, 1L);
        if (removedEmployee != null) {
            System.out.println(removedEmployee.getFirstName());
        } else {
            System.out.println("Employee not found");
        }

        employeeService.changeEmployeeName(2, "Edward");

        Employee employee = employeeService.findEmployeeById(2);
        Department department = employee.getDepartment();
        ParkingSpace parkingSpace = employee.getParkingSpace();
        System.out.println(employee.toString() + employee.getProjects().size());

        employeeService.findAllEmployees();
    }
}
