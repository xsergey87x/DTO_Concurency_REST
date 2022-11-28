package com.example.demo.web;

import com.example.demo.DTO.entityDto.TeacherDTO;
import com.example.demo.DTO.serviceDto.Mapper;
import com.example.demo.entity.Group;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherRestController {

private final TeacherService teacherService;
private final Mapper mapper;

  public TeacherRestController(TeacherService teacherService, Mapper mapper) {
    this.teacherService = teacherService;
    this.mapper = mapper;
  }

  @PostMapping(value = "/saveTeacher")
  public Teacher addTeacher(@RequestBody Teacher teacher)
  {
      return teacherService.createTeacher(teacher);
  }

  @PostMapping(value = "/updateTeacher")
  public Teacher updateTeacher(@RequestBody Teacher teacher)
  {
    return teacherService.updateTeacher(teacher);
  }

  ////////////////////////////////////////////////////////////////////////////

  @PostMapping(value = "/addGroupToTeacher/{teacherId}")
  public Teacher addGroupToTeacher(@RequestBody Group group, @PathVariable Long teacherId)
  {
    return teacherService.addGroupToTeacher(group,teacherId);
  }

  @GetMapping(value = "/removeGroupToTeacher/{groupId}")
  public Teacher removeGroupToTeacher(@PathVariable Long groupId)
  {
    return null;
  }

  @GetMapping(value = "/getAllGroupByTeacher/{teacherId}")
  public List<Group> getAllGroupByTeacher(@PathVariable Long teacherId)
  {
    return null;
  }
  ////////////////////////////////////////////////////////////////////////////

  @GetMapping(value = "/getAll")
  public List<Teacher> getAllTeacher()  {return teacherService.getAllTeacher();}

  @GetMapping(value = "/getAllDto")
  public List<TeacherDTO> getAllDtoTeacher()  {return teacherService.getAllTeacher().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());}

  @GetMapping(value = "/getById")
  public Optional getAllTeacher(@RequestParam Long id)
  {
    return teacherService.getTeacherById(id);
  }

  @GetMapping(value = "/getDtoById")
  public TeacherDTO getAllDtoTeacher(@RequestParam Long id)
  {
    return mapper.mapEntityToDto((Teacher)teacherService.getTeacherById(id).get());
  }

  @PostMapping(value = "/saveTestTeacher")
  public Teacher createTestTeacher()
  {
    return teacherService.createTeacher(new Teacher("Jordan","Peterson","male",40));
  }
}
