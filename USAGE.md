Employee App (Spring Boot)
==========================

Spring Boot application for managing employee data with CRUD operations, sorting, filtering, and salary statistics.

Quick Start
-----------

1. Build and run:

```bash
cd /workspaces/Projects
mvn spring-boot:run
```

2. **Web Dashboard:** Open http://localhost:8080 in your browser
   - View all employees in an interactive table
   - Add new employees via form
   - Edit and delete employees
   - Filter by name, department, experience
   - Sort by salary, name, or age
   - View salary statistics (highest/lowest)

API Endpoints
-------------

All REST endpoints are available at `http://localhost:8080/api/employees`

**Get all employees:**
```bash
curl http://localhost:8080/api/employees
```

**Get employee by ID:**
```bash
curl http://localhost:8080/api/employees/1
```

**Create employee:**
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"name":"John","age":32,"department":"IT","salary":95000,"company":"AcmeCorp","yearsExperience":7}'
```

**Update employee:**
```bash
curl -X PUT http://localhost:8080/api/employees/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"John","age":33,"department":"Engineering","salary":100000,"company":"AcmeCorp","yearsExperience":8}'
```

**Delete employee:**
```bash
curl -X DELETE http://localhost:8080/api/employees/1
```

**Sorting & Filtering:**
```bash
# Sort by salary (ascending)
curl http://localhost:8080/api/employees/sort/salary/ascending

# Sort by salary (descending)
curl http://localhost:8080/api/employees/sort/salary/descending

# Highest salary
curl http://localhost:8080/api/employees/stats/highest-salary

# Lowest salary
curl http://localhost:8080/api/employees/stats/lowest-salary

# Filter by department
curl http://localhost:8080/api/employees/filter/department/Engineering

# Filter by experience (>5 years)
curl http://localhost:8080/api/employees/filter/experience/5
```

Web Dashboard Features
-----------------------

**📊 Statistics Section**
- Total number of employees
- Highest salary (with employee name)
- Lowest salary (with employee name)

**➕ Add New Employee**
- Form to create new employees
- Real-time validation
- Auto-refresh after creation

**🔍 Filter & Sort**
- Search by employee name
- Filter by department
- Filter by years of experience
- Sort by: Salary (asc/desc), Name, or Age
- Reset filters to view all employees

**👨‍💼 Employees Table**
- Display all employees with details
- Edit button - modify employee info
- Delete button - remove employee
- Responsive table view

**Responsive Design**
- Works on desktop, tablet, and mobile
- Beautiful gradient UI with smooth interactions
- Modal dialog for editing employees
- Alert notifications for actions

Features
--------
- Spring Boot 2.7.17 with Spring Data JPA
- H2 file-based database (no external DB needed)
- RESTful API for CRUD operations
- Stream-based sorting and filtering (Java 8 Streams)
- Automatic schema creation and sample data initialization

Technical Stack
---------------
- Java 8
- Spring Boot
- Spring Data JPA / Hibernate
- SQLite
- Maven

