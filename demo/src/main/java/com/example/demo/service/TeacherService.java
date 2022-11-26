package com.example.demo.service;

import com.example.demo.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    Optional getTeacherById(Long Id);
    List<Teacher> getAllTeacher();

}
