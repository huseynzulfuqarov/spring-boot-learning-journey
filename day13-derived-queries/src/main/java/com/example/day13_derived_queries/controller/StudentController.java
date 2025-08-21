package com.example.day13_derived_queries.controller;

import com.example.day13_derived_queries.entity.Student;
import com.example.day13_derived_queries.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PatchMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateData(id, student);
    }

    @GetMapping("/search/by-mail")
    public Student searchByMail(@RequestParam String mail) {
        return studentService.getStudentByEmail(mail);
    }

    @GetMapping("/search/by-age")
    public List<Student> searchByAgeInterval(@RequestParam Integer age) {
        return studentService.getStudentsOlderThan(age);
    }

    @GetMapping("/search/by-name-containing")
    public List<Student> searchByNameContaining(@RequestParam String keyword) {
        return studentService.getStudentsByFirstNameContaining(keyword);
    }
}
