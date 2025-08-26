package org.example.day15_dto_pattern.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequestDTO {
    private String name;
    private String email;
    private int age;
    private String address;
}
