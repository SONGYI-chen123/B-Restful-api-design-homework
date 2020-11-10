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

    public void deleteStudent(Integer id) {
        for(int i = 0; i<students.size(); i++){
            if (students.get(i).getStudentId().equals(id)){
                students.remove(students.get(i));
            }
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getStudentsByGender(String gender) {
        List<Student> responseStudents = new ArrayList<>();
        for(int i = 0; i<students.size(); i++){
            if (students.get(i).getGender().equals(gender)){
                responseStudents.add(students.get(i));
            }
        }
        return responseStudents;
    }
}
