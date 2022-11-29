package com.example.demo.web;

import com.example.demo.DTO.entityDto.TeacherDTO;
import com.example.demo.DTO.entityDto.TeacherFullModelDTO;
import com.example.demo.DTO.serviceDto.Mapper;
import com.example.demo.entity.Group;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping(value = "/teacher")
public class TeacherRestController {

private final TeacherService teacherService;
private final Mapper mapper;

  public TeacherRestController(TeacherService teacherService, Mapper mapper) {
    this.teacherService = teacherService;
    this.mapper = mapper;
  }

  @PostMapping(value = "/saveTeacher")
  public ResponseEntity<Teacher> addTeacher(@Valid @RequestBody TeacherFullModelDTO teacherFullModelDTO)
  {
      return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.createTeacher(mapper.mapFullDtoToEntity(teacherFullModelDTO)));
  }

  @PostMapping(value = "/updateTeacher")
  public Teacher updateTeacher(@Valid @RequestBody Teacher teacher)
  {
    return teacherService.updateTeacher(teacher);
  }

  @PostMapping(value = "/addGroupToTeacher/{teacherId}")
  public Teacher addGroupToTeacher(@RequestBody Group group, @PathVariable Long teacherId)
  {
    return teacherService.addGroupToTeacher(group,teacherId);
  }

  @GetMapping(value = "/removeGroupToTeacher/{groupId}/{teacherId}")
  public Teacher removeGroupFromTeacher(@PathVariable Long groupId, @PathVariable Long teacherId)
  {
    return teacherService.deleteGroupFromTeacher(groupId,teacherId);
  }

  @GetMapping(value = "/getAllGroupByTeacher/{teacherId}")
  public List<Group> getAllGroupByTeacher(@PathVariable Long teacherId)
  {
    return teacherService.getAllGroupByTeacher(teacherId);
  }

  @GetMapping(value = "/getAll")
  public List<Teacher> getAllTeacher()  {return teacherService.getAllTeacher();}

  @GetMapping(value = "/getAllDto")
  public List<TeacherDTO> getAllDtoTeacher()  {return teacherService.getAllTeacher().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());}

  @GetMapping(value = "/getById")
  public Teacher getTeacherById(@RequestParam("id") @Min(0) Long id)
  {
   // return teacherService.getTeacherById(id).orElseThrow(() -> new RecordNotFoundException("Employee id '" + id + "' does no exist"));
    return teacherService.getTeacherById(id);
  }

  @GetMapping(value = "/getDtoById")
  public TeacherDTO getAllDtoTeacher(@RequestParam("id") @Min(0) Long id)
  {
    return mapper.mapEntityToDto(teacherService.getTeacherById(id));
  }

  @GetMapping(value = "/saveTestTeacher")
  public Teacher createTestTeacher()
  {
    return teacherService.createTeacher(new Teacher("Sem","Smith","male",35));
  }
}
