package com.example.schoolmanagerment.Controller;

import com.example.schoolmanagerment.Models.Subject;
import com.example.schoolmanagerment.Service.ClassRoomServices;
import com.example.schoolmanagerment.Service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  // API để lấy danh sách tất cả các môn học
  @GetMapping
  @CrossOrigin(origins = "http://localhost:4200")
  public List<Subject> getAllSubjects() {
    return subjectService.getAllSubjects();
  }

  // API để lấy thông tin một môn học dựa trên ID
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/{id}")
  public ResponseEntity<Subject> getSubjectById(@PathVariable String id) {
    Subject subject = subjectService.getSubjectById(id);
    if (subject != null) {
      return ResponseEntity.ok(subject);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // API để tạo mới một môn học
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping
  public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
    Subject createdSubject = subjectService.createSubject(subject);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
  }

  // API để cập nhật thông tin một môn học dựa trên ID
  @CrossOrigin(origins = "http://localhost:4200")
  @PutMapping("/{id}")
  public ResponseEntity<Subject> updateSubject(@PathVariable String id, @RequestBody Subject subject) {
    Subject updatedSubject = subjectService.updateSubject(id, subject);
    if (updatedSubject != null) {
      return ResponseEntity.ok(updatedSubject);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // API để xóa một môn học dựa trên ID

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
    boolean deleted = subjectService.deleteSubject(id);
    if (deleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Autowired
  private ClassRoomServices classroomService;

//  @GetMapping("/{classId}/subjects")
//  public ResponseEntity<List<Subject>> getAllSubjectsForClass(@PathVariable String classId) {
//    List<Subject> subjects = classroomService.getAllSubjectsForClass(classId);
//    return new ResponseEntity<>(subjects, HttpStatus.OK);
//  }

}
