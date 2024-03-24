package com.example.schoolmanagerment.Repository;

import com.example.schoolmanagerment.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student save(Student data);
    ArrayList<Student> findAll();
    void deleteById(Long id);
    Student findByStudentId(Long studentId);
}
