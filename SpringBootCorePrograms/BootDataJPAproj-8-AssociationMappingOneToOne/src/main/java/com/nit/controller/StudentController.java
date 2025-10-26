	package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.entity.Passport;
import com.nit.entity.Student;
import com.nit.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) { 
        this.studentService = studentService; 
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("students", studentService.listAll());
        return "students/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("passport", new Passport());
        return "students/form";
    }

    @PostMapping
    public String save(@ModelAttribute Student student) {
        studentService.createStudentWithPassport(student);
        return "redirect:/students/list";
    }

    @GetMapping("/detail/{id}")
    public String details(@PathVariable Long id, Model model) {
        studentService.findById(id).ifPresent(s -> model.addAttribute("student", s));
        return "students/detail";
    }
}
