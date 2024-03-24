import { Component } from '@angular/core';
import { Student } from '../student';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { StudentService } from '../student.service';
import { error } from 'console';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.css'
})
export class UpdateStudentComponent {
  studentId!:number;
  student: Student = new Student();

  constructor(private studentService: StudentService,
    private route: ActivatedRoute,
    private router: Router
    ){}

  ngOnInit():void{
this.studentId=this.route.snapshot.params['studentId'];
this.studentService.getStudentById(this.studentId).subscribe(data =>{
this.student=data.data;
},error=>console.log(error));
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
   this.studentService.updateStudent(this.studentId, this.student).subscribe(data=>{
this.goToStudentList();
   },error=>console.log(error));
  }
}
