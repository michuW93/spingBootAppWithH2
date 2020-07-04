package com.example.demo.Queries;


import com.example.demo.Employee.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QueryService {
    @PersistenceContext(unitName = "DynamicQueries")
    EntityManager enityManager;

    private static final String QUERY_FOR_PARKINGSPACE_LOT_FOR_EMPLOYEE = "SELECT e.parkingSpace.lot FROM Employee e WHERE e.pesel = :pesel";

    public QueryService(EntityManager entityManager) {
        this.enityManager = entityManager;
    }


    public String getParkingSpaceLotForEmployee(Employee employee){
        return enityManager.createQuery(QUERY_FOR_PARKINGSPACE_LOT_FOR_EMPLOYEE, String.class)
                .setParameter("pesel", employee.getPesel())
                .getSingleResult();
    }
}
