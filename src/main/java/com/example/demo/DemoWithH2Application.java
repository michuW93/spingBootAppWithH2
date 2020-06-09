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

        Employee employee = new Employee("Michal", "9312", 1L);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(employee);
        transaction.commit();

        Employee employee1 = em.find(Employee.class, 1L);
        System.out.println(employee1.getFirstName());
    }

}
