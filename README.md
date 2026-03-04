# Employee Management System

A modern **Spring Boot REST API** application for managing employee data with a responsive web interface.

## Overview

This project demonstrates a full-stack Java 8 application using:
- **Backend**: Spring Boot 2.7.17 with Spring Data JPA
- **Database**: H2 (embedded, file-based)
- **Frontend**: Interactive HTML5/CSS3/JavaScript dashboard
- **API**: RESTful endpoints for CRUD operations and analytics

## Features

### Core Functionality
- ✅ **CRUD Operations**: Create, Read, Update, Delete employees
- ✅ **Data Management**: Name, Age, Department, Salary, Company, Years of Experience
- ✅ **Search & Filter**: Find employees by department and years of experience
- ✅ **Sorting**: Sort by salary (ascending/descending)
- ✅ **Salary Analytics**: View highest and lowest salary employees
- ✅ **Interactive Dashboard**: Modern web UI for data visualization and management
- ✅ **Sample Data**: Pre-loaded with 5 sample employees for testing

### Technical Highlights
- Java 8 Streams for functional programming (sorting, filtering)
- Spring Data JPA for database operations
- Responsive Bootstrap-based UI
- RESTful API with JSON responses
- Automatic schema creation and data initialization

## Project Structure

```
Employee Management System/
├── pom.xml                                      # Maven configuration
├── README.md                                    # This file
├── USAGE.md                                     # API documentation
│
├── src/main/java/com/example/employee/
│   ├── EmployeeApplication.java                # Spring Boot main class
│   ├── Employee.java                           # JPA Entity
│   ├── EmployeeRepository.java                 # Spring Data JPA Repository
│   ├── EmployeeService.java                    # Business logic layer
│   └── EmployeeController.java                 # REST API endpoints
│
└── src/main/resources/
    ├── application.properties                  # Configuration file
    └── static/
        └── index.html                          # Interactive dashboard
```

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven 3.6+

### Installation & Running

1. **Clone/navigate to project:**
```bash
cd /workspaces/Projects
```

2. **Build the application:**
```bash
mvn clean package
```

3. **Run the application:**

**Option A: Using Maven**
```bash
mvn spring-boot:run
```

**Option B: Using JAR**
```bash
java -jar target/employee-app-1.0-SNAPSHOT.jar
```

4. **Access the application:**
- **Web Dashboard**: http://localhost:8080
- **H2 Console** (optional): http://localhost:8080/h2-console

## API Endpoints

### Employee Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| POST | `/api/employees` | Create new employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

### Sorting & Analytics

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/employees/sort/salary/ascending` | Sort by salary (low to high) |
| GET | `/api/employees/sort/salary/descending` | Sort by salary (high to low) |
| GET | `/api/employees/stats/highest-salary` | Get employee with highest salary |
| GET | `/api/employees/stats/lowest-salary` | Get employee with lowest salary |

### Filtering

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/employees/filter/department/{dept}` | Filter by department |
| GET | `/api/employees/filter/experience/{years}` | Filter by years of experience (>) |

## API Examples

### Get All Employees
```bash
curl http://localhost:8080/api/employees
```

### Create Employee
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "age": 32,
    "department": "Engineering",
    "salary": 95000,
    "company": "AcmeCorp",
    "yearsExperience": 7
  }'
```

### Get Highest Salary
```bash
curl http://localhost:8080/api/employees/stats/highest-salary
```

### Filter by Department
```bash
curl http://localhost:8080/api/employees/filter/department/Engineering
```

### Filter by Experience
```bash
curl http://localhost:8080/api/employees/filter/experience/5
```

## Web Dashboard Features

The interactive dashboard at `http://localhost:8080` provides:

1. **All Employees Table**
   - View complete employee records
   - Sortable columns
   - Real-time data sync

2. **Search & Filter Section**
   - Filter by department
   - Filter by years of experience
   - Quick search results

3. **Salary Statistics**
   - Highest paid employee
   - Lowest paid employee
   - Salary rankings

4. **Employee Management**
   - Add new employee form
   - Update existing employee data
   - Delete employee records
   - Real-time form validation

5. **Responsive Design**
   - Works on desktop, tablet, and mobile
   - Bootstrap-based styling
   - Smooth animations and transitions

## Sample Data

The application comes pre-populated with 5 sample employees:

| ID | Name | Age | Department | Salary | Years | Company |
|---|------|-----|-----------|--------|-------|---------|
| 1 | Alice | 30 | Engineering | $90,000 | 6 | AcmeCorp |
| 2 | Bob | 24 | Sales | $55,000 | 2 | AcmeCorp |
| 3 | Carol | 40 | Engineering | $120,000 | 15 | AcmeCorp |
| 4 | Dave | 35 | HR | $70,000 | 8 | AcmeCorp |
| 5 | Eve | 28 | Engineering | $80,000 | 4 | AcmeCorp |

## Database

### Technology
- **Type**: H2 (embedded relational database)
- **File**: `employees.db` (created in project root on first run)
- **Configuration**: See `application.properties`

### Schema
```sql
CREATE TABLE employees (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    age INTEGER,
    department VARCHAR(255),
    salary DOUBLE,
    company VARCHAR(255),
    years_experience INTEGER
)
```

## Technology Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| Java | 8 | Programming language |
| Spring Boot | 2.7.17 | Framework & dependency injection |
| Spring Data JPA | (via Boot) | ORM & data access |
| Hibernate | 5.6.15 | JPA implementation |
| H2 Database | (via Boot) | Embedded database |
| Apache Tomcat | 9.0.82 | Embedded web server |
| Bootstrap | 5.x | Frontend styling |
| JavaScript (ES6) | - | Frontend logic |

## Configuration

Edit `src/main/resources/application.properties`:

```properties
spring.application.name=employee-app
server.port=8080

# H2 Database Configuration (file-based)
spring.datasource.url=jdbc:h2:./employees
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA / Hibernate Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false

# H2 Console (optional - for debugging)
spring.h2.console.enabled=true
```

## Development

### Build Project
```bash
mvn clean compile
```

### Run Tests (if added)
```bash
mvn test
```

### Package for Production
```bash
mvn clean package -DskipTests
```

## Troubleshooting

### Port 8080 Already in Use
```bash
# Kill existing process
lsof -i :8080
kill -9 <PID>

# Or change port in application.properties
server.port=8081
```

### Database File Locked
```bash
# Remove the database file and restart
rm -f employees.db
mvn spring-boot:run
```

### API Not Responding
```bash
# Check application logs
tail -f /tmp/app.log

# Verify server is running
curl http://localhost:8080/api/employees
```

## Project Statistics

- **Lines of Code**: ~500 (backend + frontend)
- **API Endpoints**: 12
- **Database Tables**: 1
- **Entities**: 1 (Employee)
- **Total Sample Data**: 5 employees

## Future Enhancements

- [ ] User authentication & authorization
- [ ] Role-based access control (Admin, Manager, Employee)
- [ ] Export data to CSV/Excel
- [ ] Advanced search and filtering
- [ ] Employee performance metrics
- [ ] Department-wise analytics dashboard
- [ ] Database migration scripts (Flyway/Liquibase)
- [ ] Unit & integration tests
- [ ] Docker containerization
- [ ] Swagger API documentation

## License

This project is open source and available for educational and commercial use.

## Support

For issues, questions, or contributions, please refer to the project documentation or create an issue in the repository.

---

**Last Updated**: March 4, 2026  
**Version**: 1.0-SNAPSHOT  
**Status**: Fully Functional ✅