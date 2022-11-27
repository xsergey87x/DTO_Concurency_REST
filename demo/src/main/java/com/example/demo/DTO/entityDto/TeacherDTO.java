package com.example.demo.DTO.entityDto;
import lombok.Data;

@Data
public class TeacherDTO {

    public TeacherDTO() {
    }

    public TeacherDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TeacherDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private Long id;
    String firstName;
    String lastName;
}
