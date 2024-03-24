import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { error } from 'console';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrl: './create-student.component.css'
})
export class CreateStudentComponent {

student: Student = new Student();

constructor(private studentService: StudentService,
  private router: Router){}

ngOnInit():void{
}

saveStudent(){
  this.studentService.createStudent(this.student).subscribe(data => {
    console.log(data);
    this.goToStudentList();
  },
  error=> console.log(error));
}

goToStudentList(){
  this.router.navigate(["/student-list"])
}
onSubmit(){
 console.log(this.student)
this.saveStudent();
}
}
