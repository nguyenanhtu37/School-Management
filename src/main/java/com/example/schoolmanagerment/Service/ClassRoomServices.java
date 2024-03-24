package com.example.schoolmanagerment.Service;

import com.example.schoolmanagerment.Models.ClassRoom;
import com.example.schoolmanagerment.Models.ClassRoomStudent;
import com.example.schoolmanagerment.Models.ClassRoomSubject;
import com.example.schoolmanagerment.Models.ResponseObject;
import com.example.schoolmanagerment.Models.Student;
import com.example.schoolmanagerment.Models.Subject;
import com.example.schoolmanagerment.Repository.ClassRoomRepository;
import com.example.schoolmanagerment.Repository.ClassRoomStudentRepository;
import com.example.schoolmanagerment.Repository.ClassroomSubjectRepository;
import com.example.schoolmanagerment.Repository.StudentRepository;
import com.example.schoolmanagerment.Repository.SubjectRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassRoomServices {
@Autowired
    ClassRoomRepository classRoomRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassRoomStudentRepository classRoomStudentRepository;
    @Autowired
    private ClassRoomRepository classroomRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ClassroomSubjectRepository classroomSubjectRepository;

    public ClassRoom addClassRoom(ClassRoom data){

        return classRoomRepository.save(data);
    }
    public List<ClassRoom> allClassRoom(){
        List<ClassRoom> result = classRoomRepository.findAll();
        return result;
    }

    public List<ClassRoom> deleteClassRoom(String classroomId){
        classRoomRepository.deleteById(classroomId);
        List<ClassRoom> result = allClassRoom();
        return result;
    }

    public ClassRoom loadClassroomById(String classroomId) {
        ClassRoom classRoom = classRoomRepository.findByClassId(classroomId);
        if(classRoom!=null)
            return classRoom;
        else throw new RuntimeException("Classroom is not exist");
    }

    public List<Student> inClass(String classroomId){
        List<ClassRoomStudent> studentsIdList = classRoomStudentRepository.findAllByClassroomClassId(classroomId);
        List<Student> studentsInClass = new ArrayList<>();
        for(ClassRoomStudent join: studentsIdList){
            studentsInClass.add(studentRepository.findByStudentId(join.getStudent().getStudentId()));
        }
        return studentsInClass;
    }

    public List<Subject> subjectInClass(String classroomId) {
        List<ClassRoomSubject> subjectIdList = classroomSubjectRepository.findAllByClassroomClassId(classroomId);
        List<Subject> subjectInClass = new ArrayList<>();

        for (ClassRoomSubject join : subjectIdList) {
            Optional<Subject> subjectOptional = subjectRepository.findBySubjectId(join.getSubjectId());

            // Check if the subject is present before adding to the list
            subjectOptional.ifPresent(subjectInClass::add);
        }

        return subjectInClass;
    }

}
