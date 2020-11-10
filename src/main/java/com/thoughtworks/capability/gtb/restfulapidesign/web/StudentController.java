package com.thoughtworks.capability.gtb.restfulapidesign.web;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(value = "/students/add",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
}
