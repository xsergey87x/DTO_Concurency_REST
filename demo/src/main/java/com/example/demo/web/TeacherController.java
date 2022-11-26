package com.example.demo.web;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
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

  @GetMapping(value = "/getAll")
  public List<Teacher> getAllTeacher()
  {
    return teacherService.getAllTeacher();
  }

  @PostMapping(value = "/saveTestTeacher")
  public Teacher createTestTeacher()
  {
    return teacherService.createTeacher(new Teacher("Jordan","Peterson","male",40));
  }

  @GetMapping(value = "/getAllById")
  public Optional getAllTeacher(@RequestParam Long id)
  {
    return teacherService.getTeacherById(id);
  }
}
