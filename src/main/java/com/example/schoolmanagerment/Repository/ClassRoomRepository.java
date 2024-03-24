package com.example.schoolmanagerment.Repository;

import com.example.schoolmanagerment.Models.ClassRoom;
import com.example.schoolmanagerment.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom,String> {
    ClassRoom findByClassId(String classId);

}
