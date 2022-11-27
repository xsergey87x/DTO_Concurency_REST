package com.example.demo.web;

import com.example.demo.entity.Group;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupRestController {

    private final GroupService groupService;

    public GroupRestController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "/getAll")
    public List<Group> showAllGroup()
    {
        return groupService.getAllGroup();
    }


}
