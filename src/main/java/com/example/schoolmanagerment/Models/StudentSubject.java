package com.example.schoolmanagerment.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false)
    private long subjectId;

    @JsonBackReference(value = "studies")
    @ManyToOne
    @JoinColumn(name="studentId")
    private Student student;

    @JsonBackReference(value = "taught")
    @ManyToOne
    @JoinColumn(name="subjectId")
    private Subject subject;
}
