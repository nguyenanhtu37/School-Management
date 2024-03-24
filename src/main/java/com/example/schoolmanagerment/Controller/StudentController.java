package com.example.schoolmanagerment.Controller;

import com.example.schoolmanagerment.Models.ResponseObject;
import com.example.schoolmanagerment.Models.Student;
import com.example.schoolmanagerment.Repository.StudentRepository;
import com.example.schoolmanagerment.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @Autowired
    StudentRepository studentRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addStudent(@RequestBody Student data){
        studentServices.addStudent(data);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Add successfully", data));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/print")
    public ArrayList<Student> allStudent(){
        ArrayList<Student> result = studentServices.allStudent();
        return result;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/delete/{studentId}")
    public ArrayList<Student> deleteStudent(@PathVariable Long studentId){
        ArrayList<Student> result = studentServices.deleteStudent(studentId);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get/{studentId}")
    public ResponseEntity<ResponseObject> getStudent(@PathVariable Long studentId){
      Student result = studentServices.loadStudentById(studentId);
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Add successfully", result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("update/{studentId}")
    public ResponseEntity<ResponseObject> updateStudent(@PathVariable Long studentId, @RequestBody Student updateInfo){
       updateInfo.setStudentId(studentId);
       studentServices.editStudent(updateInfo);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Add successfully",studentServices.editStudent(updateInfo) ));
    }
}
