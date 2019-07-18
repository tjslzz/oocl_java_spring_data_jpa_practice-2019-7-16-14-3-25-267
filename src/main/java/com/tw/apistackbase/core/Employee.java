package com.tw.apistackbase.core;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "com_id",referencedColumnName = "id")
    private Company company;

    public Employee() {
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, Integer age, Company company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
