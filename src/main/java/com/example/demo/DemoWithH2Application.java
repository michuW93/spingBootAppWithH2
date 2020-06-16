package com.example.demo;

import com.example.demo.Employee.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class DemoWithH2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoWithH2Application.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        createEmployee(em, "Michal", "930818", 1L);

        Employee employee1 = em.find(Employee.class, 1L);
        System.out.println(employee1.getFirstName());
        removeEmployee(em, employee1.getEmployee_id());

        Employee removedEmployee = em.find(Employee.class, 1L);
        if (removedEmployee != null) {
            System.out.println(removedEmployee.getFirstName());
        } else {
            System.out.println("Employee not found");
        }

        changeEmployeeName(em, 2, "Edward");
    }

    private static void createEmployee(EntityManager em, String firstName, String pesel, long departmentId){
        Employee employee = new Employee(firstName, pesel, departmentId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(employee);
        transaction.commit();
    }

    private static void removeEmployee(EntityManager em, long employeeId) {
        Employee emp = em.find(Employee.class, employeeId);
        if (emp != null) {
            em.remove(emp);
        }
    }

    private static Employee changeEmployeeName(EntityManager em, long id, String firstName) {
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            emp.setFirstName(firstName);
            transaction.commit();
        }
        return emp;
    }
}
