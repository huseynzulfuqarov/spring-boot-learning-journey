package org.example.day09_jpa_entity.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access =  JsonProperty.Access.READ_ONLY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;

    public Student() {}

    public Student(int age, String email, String lastName, String firstName) {
        this.age = age;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
