package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EntityManager entityManager;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public Employee findByPesel(String pesel) {
        return repository.findByPesel(pesel);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findByFirstnameAndDepartment(String firstName) {
        return repository.findByFirstNameAndDepartment(firstName);
    }

    @Override
    public void findAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> emps = query.getResultList();
        System.out.println("Num of employees: " + emps.size());
    }

    @Override
    public void createEmployee(String firstName, String pesel, long departmentId) {
        Employee employee = new Employee(firstName, pesel, departmentId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }

    @Override
    public void removeEmployee(long employeeId) {
        Employee emp = entityManager.find(Employee.class, employeeId);
        if (emp != null) {
            entityManager.remove(emp);
        }
    }

    @Override
    public Employee changeEmployeeName(long id, String firstName) {
        Employee emp = entityManager.find(Employee.class, id);
        if (emp != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            emp.setFirstName(firstName);
            transaction.commit();
        }
        return emp;
    }

    @Override
    public Employee findEmployeeById(long id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            System.out.println(employee.getFirstName());
        } else {
            System.out.println("Employee not found");
        }
        return employee;
    }
}