package com.example.demo.service.Impl;

import com.example.demo.entity.Group;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.NoSuchElementException;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherRepository teacherRepository;
    GroupRepository groupRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, GroupRepository groupRepository) {
        this.teacherRepository = teacherRepository;
        this.groupRepository = groupRepository;
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

    @SneakyThrows
    @Override
    public Teacher addGroupToTeacher(Group group, Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if (teacher.isEmpty()) {throw new NoSuchElementException("Teacher with id " + teacherId + " not found"); }

           List<Group> groups = new ArrayList<>();
           if (teacher.get().getGroups() != null)
           {
               groups.addAll(teacher.get().getGroups());
           }
        group.setTeacher(teacher.get());
        groups.add(group);
        teacher.get().setGroups(groups);
        groupRepository.save(group);
        return teacherRepository.save(teacher.get());
    }

    @Override
    public Teacher deleteGroupFromTeacher(Long groupId, Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        Optional<Group> group = groupRepository.findById(groupId);
        List<Group> groups = new ArrayList<>();

        if (teacher.get().getGroups() != null)
        {
            groups.addAll(teacher.get().getGroups());
            group.get().setTeacher(null);
            groups.remove(group.get());
            teacher.get().setGroups(groups);
        }
        groupRepository.save(group.get());
        return teacherRepository.save(teacher.get());
    }

    @Override
    public List<Group> getAllGroupByTeacher(Long teacherId) {
        return teacherRepository.findById(teacherId).get().getGroups();
    }

    @Override
    public Teacher getTeacherById(Long id) {
       return teacherRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No such teacher with specified id"));
    }

    @Override
    public List<Teacher> getAllTeacher() {
               List<Teacher> teachers = new ArrayList<Teacher>();
        teacherRepository.findAll().forEach(teacher1 -> teachers.add(teacher1));
        return teachers;
    }
}
