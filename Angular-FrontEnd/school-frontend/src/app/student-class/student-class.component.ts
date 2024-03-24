import { ClassroomService } from './../classroom.service';
import { Component } from '@angular/core';
import { Student } from '../student';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-class',
  templateUrl: './student-class.component.html',
  styleUrl: './student-class.component.css'
})
export class StudentClassComponent {
  studentClass! : Student[];
  classId!:string;
  constructor(private classroomService: ClassroomService,
    private router: Router, private route: ActivatedRoute,
   ){}

    ngOnInit():void{
      this.classId=this.route.snapshot.params['classId'];
      this.getStudentByClass(this.classId)
        }

    private getStudentByClass(classId: string){
      this.classroomService.getStudentinClass(classId).subscribe(data=>{
        this.studentClass = data;
      });
    }

}
