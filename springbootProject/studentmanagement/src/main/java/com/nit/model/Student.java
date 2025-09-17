package com.nit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name length must be between 2 and 100")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 3, message = "Age must be at least 3")
    @Max(value = 99, message = "Age must be less than or equal to 99")
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