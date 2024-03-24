package com.example.schoolmanagerment.Controller;
import com.example.schoolmanagerment.Models.ClassRoom;
import com.example.schoolmanagerment.Models.ResponseObject;
import com.example.schoolmanagerment.Models.Student;
import com.example.schoolmanagerment.Repository.ClassRoomRepository;
import com.example.schoolmanagerment.Service.ClassRoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {
@Autowired
    ClassRoomServices classRoomServices;
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addStudent(@RequestBody ClassRoom data){
        classRoomServices.addClassRoom(data);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Add successfully", data));
    }

    @GetMapping("/delete/{classId}")
    public ResponseEntity<ResponseObject> deleteStudent(@PathVariable String classId){
        if(classRoomServices.loadClassroomById(classId)!=null) {
            List<ClassRoom> result = classRoomServices.deleteClassRoom(classId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "delete successfully", result ));
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("failed", "Delete failed","" ));
    }


    @GetMapping("/print")
    public List<ClassRoom> allClass(){
        List<ClassRoom> result = classRoomServices.allClassRoom();
        return result;
    }

    @GetMapping("/inclass/{classId}")
    public List<Student> getStudentByClass(@PathVariable String classId){
        //ClassRoom classRoom = classRoomServices.loadClassroomById(classId);
        List<Student> result = classRoomServices.inClass(classId.trim());
        return result;
    }
//
//    @GetMapping("/api/subject-in-class/{classId}")
//    public List<Subject> getSubjectByClassId(@PathVariable String classId){
//        List<Student rs = classRoomServices.???
//    }
}
