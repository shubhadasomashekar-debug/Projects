package com.example.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(EmployeeRepository employeeRepository) {
        return args -> {
            // Clear existing data
            employeeRepository.deleteAll();

            // Add sample data
            String COMPANY = "AcmeCorp";
            employeeRepository.save(new Employee("Alice", 30, "Engineering", 90000, COMPANY, 6));
            employeeRepository.save(new Employee("Bob", 24, "Sales", 55000, COMPANY, 2));
            employeeRepository.save(new Employee("Carol", 40, "Engineering", 120000, COMPANY, 15));
            employeeRepository.save(new Employee("Dave", 35, "HR", 70000, COMPANY, 8));
            employeeRepository.save(new Employee("Eve", 28, "Engineering", 80000, COMPANY, 4));

            System.out.println("\n--- Employee Data Initialized ---");
            System.out.println("Sample employees have been added to the database.");
            System.out.println("API endpoints available at http://localhost:8080/api/employees");
        };
    }
}
