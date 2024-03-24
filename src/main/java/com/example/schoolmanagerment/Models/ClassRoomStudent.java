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
public class ClassRoomStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long joinId;

    @JsonBackReference(value = "joins")
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @JsonBackReference(value = "have")
    @ManyToOne
    @JoinColumn(name = "classId")
    private ClassRoom classroom;

    @JsonBackReference(value = "have")
    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;

}
