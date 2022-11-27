package com.example.demo.DTO.serviceDto;

import com.example.demo.DTO.entityDto.TeacherDTO;
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

    public Teacher mapDtoToEntity(TeacherDTO teacherDTO)
    {
       return new Teacher(teacherDTO.getId(), teacherDTO.getFirstName(),teacherDTO.getLastName());
    }
}
