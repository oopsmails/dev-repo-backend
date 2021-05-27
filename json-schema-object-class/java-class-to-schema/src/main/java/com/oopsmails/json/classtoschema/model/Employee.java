package com.oopsmails.json.classtoschema.model;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    public Employee() {

    }

    public Employee(Long organizationId, Long departmentId, String name, int age, String position) {
        this.organizationId = organizationId;
        this.departmentId = departmentId;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    private Long id;
    private Long organizationId;
    private Long departmentId;
    private String name;
    private int age;
    private String position;
    private List<Address> addresses;
    private Department department;
}
