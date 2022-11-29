package com.example.demo.DTO.serviceDto;

import com.example.demo.DTO.entityDto.TeacherDTO;
import com.example.demo.DTO.entityDto.TeacherFullModelDTO;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    TeacherRepository teacherRepository;

    public Mapper(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherDTO mapEntityToDto(Teacher teacher)
    {
        TeacherDTO teacherDTO = new TeacherDTO();
            if (teacherRepository.existsById(teacher.getId()))
            {
           teacherDTO.setId(teacher.getId());
           teacherDTO.setFirstName(teacher.getFirstName());
           teacherDTO.setLastName(teacher.getLastName());
            }
            return teacherDTO;
    }

    public Teacher mapFullDtoToEntity (TeacherFullModelDTO teacherFullModelDTO)
    {
        Teacher teacher = new Teacher();
        teacher.setId(teacherFullModelDTO.getId());
        teacher.setFirstName(teacherFullModelDTO.getFirstName());
        teacher.setLastName(teacherFullModelDTO.getLastName());
        teacher.setGender(teacherFullModelDTO.getGender());
        teacher.setAge(teacherFullModelDTO.getAge());
        teacher.setEmail(teacherFullModelDTO.getEmail());
        teacher.setGroups(teacherFullModelDTO.getGroups());
        return teacher;
    }

    public Teacher mapDtoToEntity(TeacherDTO teacherDTO)
    {
       return new Teacher(teacherDTO.getId(), teacherDTO.getFirstName(),teacherDTO.getLastName());
    }
}
