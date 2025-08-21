package com.example.day13_derived_queries.repository;

import com.example.day13_derived_queries.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    List<Student> findByAgeGreaterThanEqual(int age);

    List<Student> findByNameContainingIgnoreCase(String keyword);
}