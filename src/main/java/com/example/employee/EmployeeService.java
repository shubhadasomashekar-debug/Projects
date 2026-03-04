package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(employee.getName());
            emp.setAge(employee.getAge());
            emp.setDepartment(employee.getDepartment());
            emp.setSalary(employee.getSalary());
            emp.setCompany(employee.getCompany());
            emp.setYearsExperience(employee.getYearsExperience());
            return employeeRepository.save(emp);
        }).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> sortBySalaryAscending() {
        return getAllEmployees().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public List<Employee> sortBySalaryDescending() {
        return getAllEmployees().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    public Optional<Employee> getHighestSalary() {
        return getAllEmployees().stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    public Optional<Employee> getLowestSalary() {
        return getAllEmployees().stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
    }

    public List<Employee> filterByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> filterByExperience(int years) {
        return employeeRepository.findByYearsExperienceGreaterThan(years);
    }
}
