# Employee Management System

A Spring Boot web application for managing employee data with a clean, interactive dashboard.

## Quick Start

1. **Run the app:**
```bash
cd /workspaces/Projects
mvn spring-boot:run
```

2. **Open browser:**
```
http://localhost:8080
```

That's it! 🚀

## What You Get

- ✅ View all employees
- ✅ Add new employees  
- ✅ Edit employee details
- ✅ Delete employees
- ✅ Filter by department or experience
- ✅ View salary statistics (highest/lowest)
- ✅ Search employees by name

## Technology

| Tech | Version |
|------|---------|
| Java | 8 |
| Spring Boot | 2.7.17 |
| H2 Database | Embedded |
| Bootstrap | 5.x |

## Sample Data

The app comes with 5 employees pre-loaded:

| Name | Department | Salary |
|------|-----------|--------|
| Alice | Engineering | $90,000 |
| Bob | Sales | $55,000 |
| Carol | Engineering | $120,000 |
| Dave | HR | $70,000 |
| Eve | Engineering | $80,000 |

## Project Structure

```
src/main/java/com/example/employee/
  ├── Employee.java              (Data model)
  ├── EmployeeRepository.java    (Database access)
  ├── EmployeeService.java       (Business logic)
  ├── EmployeeController.java    (REST API)
  └── EmployeeApplication.java   (Main app)

src/main/resources/
  ├── application.properties     (Config)
  └── static/index.html          (Web UI)
```

## Troubleshooting

**Port 8080 in use?**
```bash
lsof -i :8080
kill -9 <PID>
```

**Want to change port?**
Edit `src/main/resources/application.properties`:
```
server.port=8081
```

**Reset database?**
```bash
rm -f employees.mv.db
mvn spring-boot:run
```

---

✅ **Fully Functional** | 📍 **One UI at http://localhost:8080** | 🚀 **Ready to Use**