package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/employee")
@Controller
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "{pesel}")
    public Employee getEmployeeByPesel(@PathVariable("pesel") String pesel) {
        return employeeServiceImpl.findByPesel(pesel);
    }
}
