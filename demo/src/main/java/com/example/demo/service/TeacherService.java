package com.example.demo.service;

import com.example.demo.entity.Group;
import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    Teacher getTeacherById(Long Id);
    List<Teacher> getAllTeacher();
    Teacher addGroupToTeacher(Group group, Long teacherId);
    Teacher deleteGroupFromTeacher(Long groupId, Long teacherId);
    List<Group> getAllGroupByTeacher(Long teacherId);

}
