package com.example.schoolmanagerment.Service;

import com.example.schoolmanagerment.Models.Subject;
import com.example.schoolmanagerment.Repository.SubjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

  @Autowired
  private SubjectRepository subjectRepository;

  public List<Subject> getAllSubjects() {
    return subjectRepository.findAll();
  }

  public Subject getSubjectById(String subjectId) {
    return subjectRepository.findById(subjectId).orElse(null);
  }

  public Subject createSubject(Subject subject) {
    return subjectRepository.save(subject);
  }

  public Subject updateSubject(String subjectId, Subject updatedSubject) {
    Subject existingSubject = subjectRepository.findById(subjectId).orElse(null);
    if (existingSubject != null) {
      existingSubject.setSubjectName(updatedSubject.getSubjectName());
      existingSubject.setSubjectDescription(updatedSubject.getSubjectDescription());
      return subjectRepository.save(existingSubject);
    } else {
      return null;
    }
  }

  public boolean deleteSubject(String subjectId) {
    if (subjectRepository.existsById(subjectId)) {
      subjectRepository.deleteById(subjectId);
      return true;
    } else {
      return false;
    }
  }
}
