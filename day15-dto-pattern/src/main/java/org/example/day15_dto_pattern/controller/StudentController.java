package org.example.day15_dto_pattern.controller;

import org.example.day15_dto_pattern.dto.CreateStudentRequestDTO;
import org.example.day15_dto_pattern.dto.StudentResponseDTO;
import org.example.day15_dto_pattern.entity.Student;
import org.example.day15_dto_pattern.service.StudentService;
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
    public List<StudentResponseDTO> findAll() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO findById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping
    public StudentResponseDTO save(@RequestBody CreateStudentRequestDTO student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable Long id, @RequestBody CreateStudentRequestDTO student) {
        return studentService.updateData(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/email-not-like")
    public List<StudentResponseDTO> findByDomain(@RequestParam String domain) {
        return studentService.findStudentsWithEmailNotEndingWith(domain);
    }

    @GetMapping("/search/age-range")
    public List<StudentResponseDTO> findByAgeRange(@RequestParam Integer min, @RequestParam Integer max) {
        return studentService.findStudentsInAgeRange(min, max);
    }

    @GetMapping("/search/native-by-name")
    public StudentResponseDTO findByNameNative(@RequestParam String name) {
        return studentService.findStudentByNameNative(name);
    }
}