package com.example.demo.web;

import com.example.demo.entity.Group;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupRestController {

    private final GroupService groupService;

    public GroupRestController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(value = "/createGroup")
    public Group saveGroup(@RequestBody Group group)
    {
        return groupService.saveGroup(group);
    }

    @GetMapping(value = "/getAll")
    public List<Group> showAllGroup()
    {
        return groupService.getAllGroup();
    }


}
