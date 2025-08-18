package org.example.day10_jpa_repository;

import org.example.day10_jpa_repository.entity.Student;
import org.example.day10_jpa_repository.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class Day10JpaRepositoryApplication implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public Day10JpaRepositoryApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Day10JpaRepositoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student("Elvin", "Mammadov", "elvin@example.com", 25);
        Student student2 = new Student("Aysel", "Quliyeva", "aysel@example.com", 22);
        Student student3 = new Student("Samir", "Aliyev", "samir@example.com", 28);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
    }
}
