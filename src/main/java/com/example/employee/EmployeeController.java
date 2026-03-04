package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> emp = employeeService.getEmployeeById(id);
        return emp.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee created = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updated = employeeService.updateEmployee(id, employee);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sort/salary/ascending")
    public ResponseEntity<List<Employee>> sortBySalaryAscending() {
        return ResponseEntity.ok(employeeService.sortBySalaryAscending());
    }

    @GetMapping("/sort/salary/descending")
    public ResponseEntity<List<Employee>> sortBySalaryDescending() {
        return ResponseEntity.ok(employeeService.sortBySalaryDescending());
    }

    @GetMapping("/stats/highest-salary")
    public ResponseEntity<Map<String, Object>> getHighestSalary() {
        Optional<Employee> emp = employeeService.getHighestSalary();
        Map<String, Object> response = new HashMap<>();
        if (emp.isPresent()) {
            response.put("employee", emp.get());
            response.put("salary", emp.get().getSalary());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/stats/lowest-salary")
    public ResponseEntity<Map<String, Object>> getLowestSalary() {
        Optional<Employee> emp = employeeService.getLowestSalary();
        Map<String, Object> response = new HashMap<>();
        if (emp.isPresent()) {
            response.put("employee", emp.get());
            response.put("salary", emp.get().getSalary());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filter/department/{department}")
    public ResponseEntity<List<Employee>> filterByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(employeeService.filterByDepartment(department));
    }

    @GetMapping("/filter/experience/{years}")
    public ResponseEntity<List<Employee>> filterByExperience(@PathVariable int years) {
        return ResponseEntity.ok(employeeService.filterByExperience(years));
    }
}
