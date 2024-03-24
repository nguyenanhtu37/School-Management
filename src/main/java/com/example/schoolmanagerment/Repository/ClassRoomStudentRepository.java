package com.example.schoolmanagerment.Repository;

import com.example.schoolmanagerment.Models.ClassRoom;
import com.example.schoolmanagerment.Models.ClassRoomStudent;
import com.example.schoolmanagerment.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface ClassRoomStudentRepository extends JpaRepository<ClassRoomStudent,Long> {
    ClassRoomStudent findByStudentStudentId(Long studentId);
    ArrayList<ClassRoomStudent> findByStudent(Student student);
    void deleteByStudentAndClassroom(Student student, ClassRoom classRoom);
    ArrayList<ClassRoomStudent> findAllByClassroomClassId(String classId);
}
