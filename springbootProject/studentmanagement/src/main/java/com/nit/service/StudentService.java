package com.nit.service;

import com.nit.Repository.StudentRepository;
import com.nit.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student updatedstudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedstudent.getName());
            student.setAge(updatedstudent.getAge());
            student.setStudentClass(updatedstudent.getStudentClass());
            student.setScores(updatedstudent.getScores());
            return student;
        });
    }

    public boolean deleteStudent(Long id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return true;
        }).orElse(false);
    }

    public List<Student> findByName(String name){
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Student> findByClass(String studentClass) {
        return studentRepository.findByStudentClassIgnoreCase(studentClass);
    }
}
