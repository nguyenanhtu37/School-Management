package com.example.schoolmanagerment.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String fullName;
    private String phone;
    private String email;
    private Timestamp dayOfBirth;

    @JsonManagedReference(value = "joins")
    @OneToMany(mappedBy = "student")
    List<ClassRoomStudent> joins;

    @JsonManagedReference(value = "studies")
    @OneToMany(mappedBy = "student")
    List<StudentSubject> study;

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
