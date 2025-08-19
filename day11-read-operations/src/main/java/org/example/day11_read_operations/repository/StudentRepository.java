package org.example.day11_read_operations.repository;

import org.example.day11_read_operations.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
