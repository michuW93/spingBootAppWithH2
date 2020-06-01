package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/employee")
@RestController
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping
    public List<Employee> getAllEmplyees() {
        return employeeServiceImpl.findAll();
    }

    @GetMapping(path = "{pesel}")
    public Employee getEmployeeByPesel(@PathVariable("pesel") String pesel) {
        return employeeServiceImpl.findByPesel(pesel);
    }

    @GetMapping(path="{firstName}/{department}")
    public Employee getEmployeeByFirstNameAndDepartment(@PathVariable("firstName") String firstName, @PathVariable("department") Long department){
        return employeeServiceImpl.findByFirstnameAndDepartment(firstName, department);
    }
}
