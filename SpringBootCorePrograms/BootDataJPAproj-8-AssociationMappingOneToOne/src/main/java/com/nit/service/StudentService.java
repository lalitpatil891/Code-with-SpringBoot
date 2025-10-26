package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.entity.Student;
import com.nit.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;

	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Transactional
	public Student createStudentWithPassport(Student student) {
		// since CascadeType.ALL on Student.passport, saving student will persist
		// passport
		return studentRepo.save(student);
	}

	@Transactional(readOnly = true)
	public List<Student> listAll() {
		return studentRepo.findAll();
	}

	public Optional<Student> findById(Long id) {
		return studentRepo.findById(id);
	}

	@Transactional
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}
}
