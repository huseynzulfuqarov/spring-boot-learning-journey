package org.example.day14_custom_queries.service;

import org.example.day14_custom_queries.entity.Student;
import org.example.day14_custom_queries.repository.StudentRepository;
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

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student updateData(Long id, Student studentDetails) {
        Student existingStudent = findById(id);
        existingStudent.setName(studentDetails.getName());
        existingStudent.setAge(studentDetails.getAge());
        existingStudent.setAddress(studentDetails.getAddress());
        existingStudent.setEmail(studentDetails.getEmail());
        return studentRepository.save(existingStudent);
    }

    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentsWithEmailNotEndingWith(String domain) {
        return studentRepository.findStudentsWithEmailNotEndingWith(domain);
    }

    public List<Student> findStudentsInAgeRange(int min, int max) {
        return studentRepository.findStudentsInAgeRange(min, max);
    }

    public Student findStudentByNameNative(String name) {
        return studentRepository.findStudentByNameNative(name)
                .orElseThrow(() -> new RuntimeException("Student not found with name: " + name));
    }
}