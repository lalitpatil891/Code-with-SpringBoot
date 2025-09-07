package com.lp.profile_demo.service;

import com.lp.profile_demo.entity.Course;
import com.lp.profile_demo.entity.Student;
import com.lp.profile_demo.repository.StudentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dev")
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student s)
    {
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
