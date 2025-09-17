package com.lp.profile_demo.controller;

import com.lp.profile_demo.entity.Course;
import com.lp.profile_demo.entity.Student;
import com.lp.profile_demo.service.CourseService;
import com.lp.profile_demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {

    private final StudentService studentService;
    private final CourseService courseService;

    public AppController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public Object add(@RequestBody Object obj) {
        if(studentService != null)
            return  studentService.addStudent((Student) obj);
        else
            return courseService.addCourse((Course) obj);
    }

    @GetMapping("/all")
    public Object getAll() {
        if(studentService != null)
            return studentService.getAllStudents();
        else
            return courseService.getAllCourses();
    }

}
