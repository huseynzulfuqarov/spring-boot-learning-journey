package org.example.day15_dto_pattern.service;

import org.example.day15_dto_pattern.dto.CreateStudentRequestDTO;
import org.example.day15_dto_pattern.dto.StudentResponseDTO;
import org.example.day15_dto_pattern.entity.Student;
import org.example.day15_dto_pattern.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDTO> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public StudentResponseDTO findStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return toResponseDto(student);
    }

    public StudentResponseDTO saveStudent(CreateStudentRequestDTO requestDto) {
        Student studentToSave = toEntity(requestDto);
        Student savedStudent = studentRepository.save(studentToSave);
        return toResponseDto(savedStudent);
    }

    public StudentResponseDTO updateData(Long id, CreateStudentRequestDTO studentDetails) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(studentDetails.getName());
        existingStudent.setAge(studentDetails.getAge());
        existingStudent.setAddress(studentDetails.getAddress());
        existingStudent.setEmail(studentDetails.getEmail());

        Student updatedStudent = studentRepository.save(existingStudent);
        return toResponseDto(updatedStudent);
    }

    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    public List<StudentResponseDTO> findStudentsWithEmailNotEndingWith(String domain) {
        return studentRepository.findStudentsWithEmailNotEndingWith(domain)
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public List<StudentResponseDTO> findStudentsInAgeRange(int min, int max) {
        List<Student> students = studentRepository.findStudentsInAgeRange(min, max);
        List<StudentResponseDTO> studentsDTO = new ArrayList<>();
        for (Student student : students) {
            studentsDTO.add(toResponseDto(student));
        }
        return studentsDTO;
    }

    public StudentResponseDTO findStudentByNameNative(String name) {
        Student student = studentRepository.findStudentByNameNative(name)
                .orElseThrow(() -> new RuntimeException("Student not found with name: " + name));
        return toResponseDto(student);
    }


    private StudentResponseDTO toResponseDto(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());
        return dto;
    }

    private Student toEntity(CreateStudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAddress(dto.getAddress());
        student.setAge(dto.getAge());
        return student;
    }
}