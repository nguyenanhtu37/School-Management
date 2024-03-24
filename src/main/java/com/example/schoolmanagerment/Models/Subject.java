package com.example.schoolmanagerment.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
  @Id

//  private String id;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String subjectId;
  private String subjectName;
  private String subjectDescription;
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String classroomClassId;
}