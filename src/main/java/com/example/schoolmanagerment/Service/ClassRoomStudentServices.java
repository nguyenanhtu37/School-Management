package com.example.schoolmanagerment.Service;

import com.example.schoolmanagerment.Models.ClassRoom;
import com.example.schoolmanagerment.Models.ClassRoomStudent;
import com.example.schoolmanagerment.Models.Student;
import com.example.schoolmanagerment.Repository.ClassRoomRepository;
import com.example.schoolmanagerment.Repository.ClassRoomStudentRepository;
import com.example.schoolmanagerment.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClassRoomStudentServices {
    @Autowired
    ClassRoomStudentRepository classRoomStudentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRoomRepository classRoomRepository;
    public ClassRoomStudent joinClass(Long studentId, String classId){
        ClassRoomStudent classRoomStudent = new ClassRoomStudent();
        classRoomStudent.setStudent(studentRepository.findByStudentId(studentId));
        classRoomStudent.setClassroom(classRoomRepository.findByClassId(classId));
        return classRoomStudentRepository.save(classRoomStudent);
    }

    @Transactional
    public void moveOutClass(Long studentId, String classId){
        classRoomStudentRepository.deleteByStudentAndClassroom(studentRepository.findByStudentId(studentId)
                , classRoomRepository.findByClassId(classId));
    }


    public boolean isInsideClass(Long studentId, String classId){
        Student student =  studentRepository.findByStudentId(studentId);
        ArrayList<ClassRoomStudent> joins = classRoomStudentRepository.findByStudent(student);
        for (ClassRoomStudent join:joins) {
            if (join.getClassroom().getClassId().matches(classId)) return true;
        }
        return  false;
    }
}
