package com.example.schoolmanagerment.Controller;

import com.example.schoolmanagerment.Models.ClassRoomStudent;
import com.example.schoolmanagerment.Models.ResponseObject;
import com.example.schoolmanagerment.Models.Student;
import com.example.schoolmanagerment.Service.ClassRoomServices;
import com.example.schoolmanagerment.Service.ClassRoomStudentServices;
import com.example.schoolmanagerment.Service.StudentServices;
import com.example.schoolmanagerment.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/classfuction")
public class ClassRoomStudentController {
    @Autowired
    ClassRoomStudentServices classRoomStudentServices;

    @Autowired
    ClassRoomServices classRoomServices;

    @Autowired
    StudentServices studentServices;

    @Autowired
    SubjectService subjectService;

    @GetMapping("/join")
    public ResponseEntity<ResponseObject> joinClass(@RequestParam Long studentId, @RequestParam String classId){
        try {
            if (classRoomServices.loadClassroomById(classId) != null
                    && studentServices.loadStudentById(studentId) != null
                    && !classRoomStudentServices.isInsideClass(studentId, classId)) {
                ClassRoomStudent result = classRoomStudentServices.joinClass(studentId, classId);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Join successfully", result));
            } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("failed", "student had already join this class", ""));
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("failed", "student or class is not exist", ""));
        }
    }
    @GetMapping("/moveout")
    public ResponseEntity<ResponseObject> deleteStudent(@RequestParam Long studentId, @RequestParam String classId){
        if(classRoomServices.loadClassroomById(classId)!= null
                && studentServices.loadStudentById(studentId)!=null
                && classRoomStudentServices.isInsideClass(studentId,classId)==true) {
            classRoomStudentServices.moveOutClass(studentId,classId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Move out successfully",""));
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("failed", "Class or Student not exist", ""));
    }
}
