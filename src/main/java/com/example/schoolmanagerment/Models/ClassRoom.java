package com.example.schoolmanagerment.Models;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ClassRoom")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String classId;

    @JsonManagedReference(value = "have")
    @OneToMany(mappedBy = "classroom")
    List<ClassRoomStudent> joins;

    @JsonManagedReference(value = "contain")
    @OneToMany(mappedBy = "classroom")
    List<ClassRoomSubject> subjectsJoins;

//    @JsonManagedReference(value = "have")
//    @OneToMany(mappedBy = "classroom")  // mappedBy should point to the field in Subject that owns the relationship
//    private List<Subject> subjects;
}
