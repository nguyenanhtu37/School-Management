package com.example.schoolmanagerment.Repository;

import com.example.schoolmanagerment.Models.ClassRoomStudent;
import com.example.schoolmanagerment.Models.ClassRoomSubject;
import com.example.schoolmanagerment.Models.Subject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomSubjectRepository extends JpaRepository<Subject, String> {
//  ArrayList<ClassRoomSubject> findAllByClassroomClassId(String classId);
  List<ClassRoomSubject> findAllByClassroomClassId(String classId);
}
