package com.example.demo.service.Impl;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return (Teacher) teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return teacher;
    }

    @Override
    public Optional getTeacherById(Long id) {
       return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
               List<Teacher> teachers = new ArrayList<Teacher>();
        teacherRepository.findAll().forEach(teacher1 -> teachers.add(teacher1));

//        List<Teacher> teachers = new ArrayList<>();
//        teacherIteration.forEach(teacher -> teachers.add(teacher));
        return teachers;
    }
}
