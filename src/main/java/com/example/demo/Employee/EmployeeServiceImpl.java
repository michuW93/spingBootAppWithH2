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
    private final EntityManager em;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, EntityManager entityManager) {
        this.repository = repository;
        em = entityManager;
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

    public void findAllEmployees() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> emps = query.getResultList();
        System.out.println("Num of employees: " + emps.size());
    }

    public void createEmployee(String firstName, String pesel, long departmentId) {
        Employee employee = new Employee(firstName, pesel, departmentId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(employee);
        transaction.commit();
    }

    public void removeEmployee(long employeeId) {
        Employee emp = em.find(Employee.class, employeeId);
        if (emp != null) {
            em.remove(emp);
        }
    }

    public Employee changeEmployeeName(long id, String firstName) {
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            emp.setFirstName(firstName);
            transaction.commit();
        }
        return emp;
    }

    public Employee findEmployeeById(long id) {
        Employee employee = em.find(Employee.class, id);
        if (employee != null) {
            System.out.println(employee.getFirstName());
        } else {
            System.out.println("Employee not found");
        }
        return employee;
    }
}