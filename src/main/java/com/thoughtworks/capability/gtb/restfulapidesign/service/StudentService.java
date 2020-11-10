package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        Student newStudent = Student.builder()
                .studentId(student.getStudentId())
                .studentName(student.getStudentName())
                .gender(student.getGender())
                .studentNote(student.getStudentNote())
                .build();
        students.add(newStudent);
    }
}
