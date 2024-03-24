import { Component } from '@angular/core';
import { Classroom } from '../classroom';
import { ClassroomService } from '../classroom.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-classroom-list',
  templateUrl: './classroom-list.component.html',
  styleUrl: './classroom-list.component.css'
})
export class ClassroomListComponent {
  classrooms! : Classroom[];
  constructor(private classroomService: ClassroomService,
    private router: Router){}
    ngOnInit():void{
      this.getClassroom();
    }

    private getClassroom(){
      this.classroomService.getClassroomList().subscribe(data=>{
        this.classrooms = data;
      });
    }
    viewClass(classId: string){
      this.router.navigate(["student-class",classId]);
      }

      toJoin(classId: string){
        this.router.navigate(["join-class"],{queryParams:{classId:[classId]}});
        }

out(classId: string){
  this.router.navigate(["out-class"],{queryParams:{classId:[classId]}});
}
}
