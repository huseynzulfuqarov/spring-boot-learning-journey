package com.example.day13_derived_queries.service;

import com.example.day13_derived_queries.entity.Student;
import com.example.day13_derived_queries.repository.StudentRepository;
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
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found with email: " + email));
    }

    public List<Student> getStudentsOlderThan(int age) {
        return studentRepository.findByAgeGreaterThanEqual(age);
    }

    public List<Student> getStudentsByFirstNameContaining(String keyword) {
        return studentRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    public Student updateData(Long id, Student studentDetails) {
        Student existingStudent  = findById(id);
        existingStudent.setName(studentDetails.getName());
        existingStudent.setAge(studentDetails.getAge());
        existingStudent.setAddress(studentDetails.getAddress());
        existingStudent.setEmail(studentDetails.getEmail());

        return studentRepository.save(existingStudent);
    }
}