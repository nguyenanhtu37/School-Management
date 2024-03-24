package com.example.schoolmanagerment.Repository;

import com.example.schoolmanagerment.Models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, String> {
  Optional<Subject> findBySubjectId(String subjectId);
}
