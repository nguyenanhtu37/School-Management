package com.example.schoolmanagerment.Service;
import com.example.schoolmanagerment.Models.Student;
import com.example.schoolmanagerment.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Service
public class StudentServices {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student data){
        return studentRepository.save(data);
    }

    public ArrayList<Student> allStudent(){
        ArrayList<Student> result = studentRepository.findAll();
        return result;
    }

    public ArrayList<Student> deleteStudent(Long studentId){
       studentRepository.deleteById(studentId);
        ArrayList<Student> result = allStudent();
        return result;
    }

    public Student loadStudentById(long id) {
        Student post = studentRepository.findByStudentId(id);
        if(post!=null)
            return post;
        else throw new RuntimeException("Student is not exist");
    }

    public Student editStudent(Student students){
        return studentRepository.findById(students.getStudentId())
                .map(student -> {
                    student.setPhone(students.getPhone());
                    student.setFullName(students.getFullName());
                    student.setEmail(students.getEmail());
                    student.setDayOfBirth(students.getDayOfBirth());
                    return  studentRepository.save(student);
                }).orElseThrow(()-> new RuntimeException("Student not exits !"));
    }
}
