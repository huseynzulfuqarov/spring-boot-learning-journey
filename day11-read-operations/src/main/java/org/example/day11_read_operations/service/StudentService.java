package org.example.day11_read_operations.service;

import org.example.day11_read_operations.entity.Student;
import org.example.day11_read_operations.exception.StudentNotFoundException;
import org.example.day11_read_operations.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
