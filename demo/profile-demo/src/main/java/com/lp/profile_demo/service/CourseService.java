package com.lp.profile_demo.service;

import com.lp.profile_demo.entity.Course;
import com.lp.profile_demo.repository.CourseRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("test")
public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public Course addCourse(Course c) {
        return repo.save(c);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }
}