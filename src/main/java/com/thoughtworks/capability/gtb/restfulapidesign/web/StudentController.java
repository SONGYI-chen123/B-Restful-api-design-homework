package com.thoughtworks.capability.gtb.restfulapidesign.web;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PostMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> getStudents(@RequestParam (required = false) String gender){
        if(gender == null){
            return studentService.getStudents();
        }
        return studentService.getStudentsByGender(gender);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/update/{id}")
    public void updateStudentInfo(@RequestBody Student student,@PathVariable Integer id){
        studentService.updateStudentInfo(student,id);
    }

    @GetMapping("/grouping")
    public List<Group> divideIntoGroups(){
        return studentService.divideIntoGroups();
    }
}
