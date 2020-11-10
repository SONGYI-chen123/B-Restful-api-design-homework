package com.thoughtworks.capability.gtb.restfulapidesign.web;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final StudentService studentService;

    GroupController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/update/{id}")
    public void updateGroupName(@RequestBody String groupName, @PathVariable Integer id){
        studentService.updateGroupName(groupName,id);
    }

    @GetMapping
    public List<Group> getGroups(){
        return studentService.getGroups();
    }

}
