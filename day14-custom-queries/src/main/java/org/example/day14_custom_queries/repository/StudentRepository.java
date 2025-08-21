package org.example.day14_custom_queries.repository;

import org.example.day14_custom_queries.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email NOT LIKE %:domain")
    List<Student> findStudentsWithEmailNotEndingWith(@Param("domain") String domain);

    @Query("SELECT s FROM Student s WHERE s.age BETWEEN :minAge AND :maxAge")
    List<Student> findStudentsInAgeRange(@Param("minAge") int min, @Param("maxAge") int max);

    @Query(value = "SELECT * FROM Student_tb WHERE name = :studentName LIMIT 1", nativeQuery = true)
    Optional<Student> findStudentByNameNative(@Param("studentName") String name);
}