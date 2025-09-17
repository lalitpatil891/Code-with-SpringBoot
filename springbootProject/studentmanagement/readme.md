Here is a **production-level Spring Boot Student Management System** backend example.  
It uses **MySQL** as the database, **Spring Data JPA** for ORM, and includes **validation** and **error handling**.  
This project supports CRUD for students and exposes RESTful API endpoints.

---

```xml name=pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>student-management</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.0</version>
        <relativePath/>
    </parent>

    <properties>
        <java.version>17</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

---

```properties name=src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# server.port=8080
```

---

```java name=src/main/java/com/example/studentmanagement/StudentManagementApplication.java
package com.example.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }
}
```

---

```java name=src/main/java/com/example/studentmanagement/model/Student.java
package com.example.studentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name length must be between 2 and 100")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 3, message = "Age must be at least 3")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private Integer age;

    @NotBlank(message = "Class is required")
    @Size(max = 50, message = "Class name must be less than 50 characters")
    private String studentClass;

    @NotNull(message = "Scores are required")
    @Min(value = 0, message = "Scores must be >= 0")
    @Max(value = 100, message = "Scores must be <= 100")
    private Integer scores;

    public Student() {}

    public Student(String name, Integer age, String studentClass, Integer scores) {
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
        this.scores = scores;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getStudentClass() { return studentClass; }
    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }

    public Integer getScores() { return scores; }
    public void setScores(Integer scores) { this.scores = scores; }
}
```

---

```java name=src/main/java/com/example/studentmanagement/repository/StudentRepository.java
package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByStudentClassIgnoreCase(String studentClass);
}
```

---

```java name=src/main/java/com/example/studentmanagement/service/StudentService.java
package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setStudentClass(updatedStudent.getStudentClass());
            student.setScores(updatedStudent.getScores());
            return studentRepository.save(student);
        });
    }

    public boolean deleteStudent(Long id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return true;
        }).orElse(false);
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Student> findByClass(String studentClass) {
        return studentRepository.findByStudentClassIgnoreCase(studentClass);
    }
}
```

---

```java name=src/main/java/com/example/studentmanagement/exception/GlobalExceptionHandler.java
package com.example.studentmanagement.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

---

```java name=src/main/java/com/example/studentmanagement/controller/StudentController.java
package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Validated
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Register new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // Update student info
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        return studentService.updateStudent(id, student)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Search by name
    @GetMapping("/searchByName")
    public List<Student> findByName(@RequestParam("name") String name) {
        return studentService.findByName(name);
    }

    // Search by class
    @GetMapping("/searchByClass")
    public List<Student> findByClass(@RequestParam("class") String studentClass) {
        return studentService.findByClass(studentClass);
    }
}
```

---

```java name=src/test/java/com/example/studentmanagement/StudentManagementApplicationTests.java
package com.example.studentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentManagementApplicationTests {
    @Test
    void contextLoads() {
    }
}
```

---

## How to Run

1. **Prepare MySQL:**
   ```sql
   CREATE DATABASE studentdb;
   ```
    - Set your MySQL username & password in `application.properties`.

2. **Build and Run:**
    - Run `mvn spring-boot:run` from the project root.

3. **API Endpoints:**
    - `GET    /api/students` — List all students
    - `GET    /api/students/{id}` — Get student by ID
    - `POST   /api/students` — Register new student (JSON body, validation)
    - `PUT    /api/students/{id}` — Update student (JSON body, validation)
    - `DELETE /api/students/{id}` — Delete student
    - `GET    /api/students/searchByName?name=xyz` — Search by name
    - `GET    /api/students/searchByClass?class=xyz` — Search by class

## Features

- **Validation:** All fields are validated, errors are returned with details.
- **Error Handling:** Centralized exception handler returns meaningful error responses.
- **Clean Architecture:** Separation of model, repository, service, controller, and exception handling.
- **Ready for Production:** Add authentication, pagination, or more business logic as needed.