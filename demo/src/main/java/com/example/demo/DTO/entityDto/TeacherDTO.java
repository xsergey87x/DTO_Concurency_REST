package com.example.demo.DTO.entityDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    @NotBlank
    @Size(min = 2, message = "teacher first name should have at least 2 characters")
    String firstName;

    @NotBlank
    @Size(min = 2, message = "teacher last name should have at least 2 characters")
    String lastName;
}
