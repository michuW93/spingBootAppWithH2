package com.example.demo;

import com.example.demo.Address.Address;
import com.example.demo.Department.Department;
import com.example.demo.Employee.Employee;
import com.example.demo.Employee.EmployeeServiceImpl;
import com.example.demo.Queries.QueryService;
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

        Address address = new Address();
        address.setCity("Wroclaw");
        address.setZip("50-542");

        Employee employee = employeeService.findEmployeeById(2);
        employee.setAddress(address);
        employeeService.saveEmployee(employee);

        System.out.println(employee.toString() + employee.getProjects().size());

        QueryService queryService = new QueryService(em);
        System.out.println("Result from query service - parking space lot: " + queryService.getParkingSpaceLotForEmployee(employee));
        System.out.println("Result from query service - name of department: " + queryService.getCompanyIdForEmployee(employee));
        System.out.println("Result from @NamedQuery - employee: " + employeeService.findEmployeeByPesel("234"));
        System.out.println("Result from @NamedQuery - employees for department: " + employeeService.findEmployeesForDepartment(2L));

        employeeService.assignDepartment(1L, "234");
        employeeService.findAllEmployees();

        System.out.println("Employee taken by criteria API: " + employeeService.getEmployeeById(2));
    }
}
