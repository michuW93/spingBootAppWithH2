package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee findByPesel(String pesel) {
        return repository.findByPesel(pesel);
    }
}
