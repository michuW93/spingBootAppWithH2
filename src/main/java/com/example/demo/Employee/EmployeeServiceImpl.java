package com.example.demo.Employee;

import com.example.demo.Department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public void createEmployee(String firstName, String pesel, Department department) {
        Employee employee = new Employee(firstName, pesel, new Department(1L));
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

    public Employee saveEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
        return employee;
    }

    public Employee findEmployeeByPesel(String pesel) {
        return entityManager.createNamedQuery("Employee.findByPesel", Employee.class)
                .setParameter("pesel", pesel)
                .getSingleResult();
    }

    public List<Employee> findEmployeesForDepartment(Long departmentId) {
        return entityManager.createNamedQuery("Employee.findEmployeesForDepartment", Employee.class)
                .setParameter("departmentId", departmentId)
                .getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void assignDepartment(Long departmentId, String pesel) {
        EntityTransaction transaction = entityManager.getTransaction(); //normally annotation would be enough but there is problem with @Transactional with H2 db
        transaction.begin();
        entityManager.createQuery("UPDATE Employee e set e.department.departmentId = :departmentId where e.pesel = :pesel")
                .setParameter("departmentId", departmentId)
                .setParameter("pesel", pesel)
                .executeUpdate();
        transaction.commit();
    }
}