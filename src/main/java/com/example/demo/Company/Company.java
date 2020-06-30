package com.example.demo.Company;

import com.example.demo.Address.Address;

import javax.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private long companyId;
    @Column(name = "name")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state", column = @Column(name = "PROVINCE")),
            @AttributeOverride(name = "zip", column = @Column(name = "POSTAL_CODE"))})
    private Address address;

    public long getId() {
        return companyId;
    }

    public void setId(long id) {
        this.companyId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
