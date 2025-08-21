package org.example.day14_custom_queries.controller;

import org.example.day14_custom_queries.entity.Student;
import org.example.day14_custom_queries.service.StudentService;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateData(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/email-not-like")
    public List<Student> findByDomain(@RequestParam String domain) {
        return studentService.findStudentsWithEmailNotEndingWith(domain);
    }

    @GetMapping("/search/age-range")
    public List<Student> findByAgeRange(@RequestParam Integer min, @RequestParam Integer max) {
        return studentService.findStudentsInAgeRange(min, max);
    }

    @GetMapping("/search/native-by-name")
    public Student findByNameNative(@RequestParam String name) {
        return studentService.findStudentByNameNative(name);
    }
}