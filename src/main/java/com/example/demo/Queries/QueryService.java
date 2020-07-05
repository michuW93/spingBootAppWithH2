package com.example.demo.Queries;


import com.example.demo.Employee.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QueryService {
    private static final String PESEL = "pesel";
    private static final String QUERY_FOR_PARKINGSPACE_LOT_FOR_EMPLOYEE = "SELECT e.parkingSpace.lot FROM Employee e WHERE e.pesel = :pesel";
    private static final String QUERY_FOR_DEPARTMENT_NAME_FOR_EMPLOYEE = "SELECT e.department.name FROM Employee e WHERE e.pesel = :pesel";

    @PersistenceContext(unitName = "DynamicQueries")
    EntityManager enityManager;

    public QueryService(EntityManager entityManager) {
        this.enityManager = entityManager;
    }


    public String getParkingSpaceLotForEmployee(Employee employee){
        return enityManager.createQuery(QUERY_FOR_PARKINGSPACE_LOT_FOR_EMPLOYEE, String.class)
                .setParameter(PESEL, employee.getPesel())
                .getSingleResult();
    }

    public String getCompanyIdForEmployee(Employee employee){
        return enityManager.createQuery(QUERY_FOR_DEPARTMENT_NAME_FOR_EMPLOYEE, String.class)
                .setParameter(PESEL, employee.getPesel())
                .getSingleResult();
    }
}
