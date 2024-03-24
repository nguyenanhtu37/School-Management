import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent {
students! : Student[];
constructor(private studentServices: StudentService,
  private router: Router){}

ngOnInit():void{
  this.getStudent();
}

private getStudent(){
  this.studentServices.getStudentsList().subscribe(data=>{
    this.students = data;
  });
}

updateStudent(studentId: number){
this.router.navigate(["update-student",studentId]);
}

deleteStudent(studentId: number){
this.studentServices.deleteStudent(studentId).subscribe(data =>{
console.log(data);
this.getStudent();
})
}

}
