package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

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

    public Student getStudentById(Integer id) {
        Student studentById = new Student();
        for(int i = 0; i<students.size(); i++){
            if (students.get(i).getStudentId().equals(id)){
                studentById = students.get(i);
            }
        }
        return studentById;
    }

    public void updateStudentInfo(Student student, Integer id) {
        for (int i = 0; i<students.size();i++){
            if(students.get(i).getStudentId().equals(id)){
                if(student.getStudentName() != null){
                    students.get(i).setStudentName(student.getStudentName());
                }
                if(student.getGender() != null){
                    students.get(i).setGender(student.getGender());
                }
                if(student.getGender() != null){
                    students.get(i).setStudentNote(student.getStudentNote());
                }
            }
        }
    }

    public List<Group> divideIntoGroups() {
        int minStudentNum = students.size()/6;
        int maxStudentGroupNum = students.size()%6;
        int studentsOrderNum = 0;
        int studentsOrderLaterNum = 0;

        for(int i = 0;i<maxStudentGroupNum;i++){
            List<Student> groupStudents = new ArrayList<>();
            studentsOrderLaterNum += (minStudentNum+1);
            for(int k = studentsOrderNum;k<studentsOrderLaterNum;k++){
                groupStudents.add(students.get(k));
            }
            Group group = createGroup(i,groupStudents);
            groups.add(group);
            studentsOrderNum += (minStudentNum+1);
        }
        for(int i = maxStudentGroupNum;i<6;i++) {
            List<Student> groupStudents = new ArrayList<>();
            studentsOrderLaterNum += minStudentNum;
            for (int x = studentsOrderNum; x < studentsOrderLaterNum; x++) {
                groupStudents.add(students.get(x));
            }
            Group group = createGroup(i, groupStudents);
            groups.add(group);
            studentsOrderNum += minStudentNum;
        }

        return groups;
    }

    public Group createGroup(Integer groupId,List<Student> students){
        Group group = Group.builder()
                .groupId(groupId)
                .groupName(groupId+"组")
                .students(students)
                .build();
        return group;
    }
}
