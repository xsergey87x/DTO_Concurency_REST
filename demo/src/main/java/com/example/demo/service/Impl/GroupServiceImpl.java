package com.example.demo.service.Impl;

import com.example.demo.entity.Group;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    private final GroupRepository groupRepository;

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }
}
