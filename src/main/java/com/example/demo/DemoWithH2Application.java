package com.example.demo;

import com.example.demo.Employee.Employee;
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

        Employee employee = new Employee(158, "Michal", "9312", 1L);
        em.persist(employee);
    }

}
