import { Component } from '@angular/core';
import { ClassroomService } from '../classroom.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-join-class',
  templateUrl: './join-class.component.html',
  styleUrl: './join-class.component.css'
})
export class JoinClassComponent {
studentJoin!:number;

constructor(private classroomService: ClassroomService,
  private router: Router, private route: ActivatedRoute){}


onSubmit(){
 this.classroomService.joinStudent(this.route.snapshot.queryParamMap.get('classId')!,this.studentJoin).subscribe(data => {
  console.log(data);
  this.router.navigate(["/classroom-list"]);
},
error=> console.log(error));
}

}
