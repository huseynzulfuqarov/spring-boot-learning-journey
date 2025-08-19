package org.example.day11_read_operations.constructor;

import org.example.day11_read_operations.entity.Student;
import org.example.day11_read_operations.service.StudentService;
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

    @PostMapping("/createStudent")
    public Student create(@RequestBody Student student) {
        return  studentService.save(student);
    }
}
