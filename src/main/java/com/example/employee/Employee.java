package com.example.employee;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private int age;
    
    @Column(name = "department")
    private String department;
    
    @Column(name = "salary")
    private double salary;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "years_experience")
    private int yearsExperience;

    public Employee() {}

    public Employee(String name, int age, String department, double salary, String company, int yearsExperience) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.company = company;
        this.yearsExperience = yearsExperience;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    
    public int getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(int yearsExperience) { this.yearsExperience = yearsExperience; }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', age=%d, dept='%s', salary=%.2f, company='%s', years=%d}",
                id, name, age, department, salary, company, yearsExperience);
    }
}
