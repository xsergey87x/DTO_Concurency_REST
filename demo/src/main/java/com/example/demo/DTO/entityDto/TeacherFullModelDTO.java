package com.example.demo.DTO.entityDto;

import com.example.demo.entity.Group;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class TeacherFullModelDTO {

    public TeacherFullModelDTO(String firstName, String lastName, String gender, String email, int age, List<Group> groups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.groups = groups;
    }

    private Long id;

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotBlank
    String gender;

    @Email
    String email;

    @Min(18)
    @Max(70)
    int age;

    private List<Group> groups = new ArrayList<>();
}
