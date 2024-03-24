package com.example.schoolmanagerment.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Repository
public class ClassRoomSubject {
    @Id
    @Column(name = "subject_id") // Chỉ định tên cột khác cho subjectId
    private String subjectId;

    @JsonBackReference(value = "subjectContain")
    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;

    @JsonBackReference(value = "classroomContain")
    @ManyToOne
    @JoinColumn(name = "classId")
    private ClassRoom classroom;

    @JsonBackReference(value = "studies")
    @ManyToOne
//    @JoinColumn(name="")
//    @Column(insertable=false, updatable=false)
    private Student student;

    // Getter and setter for subjectId
//    public String getSubjectId() {
//        return subjectId;
//    }
//
//    public void setSubjectId(String subjectId) {
//        this.subjectId = subjectId;
//    }
//
//    // Additional getters and setters if needed
//    public Subject getSubject() {
//        return subject;
//    }
//
//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }
}

