import { Component } from '@angular/core';
import { ClassroomService } from '../classroom.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-out-class',
  templateUrl: './out-class.component.html',
  styleUrl: './out-class.component.css'
})
export class OutClassComponent {
  studentOut!:number;

  constructor(private classroomService: ClassroomService,
    private router: Router, private route: ActivatedRoute){}


  onSubmit(){
   this.classroomService.outStudent(this.route.snapshot.queryParamMap.get('classId')!,this.studentOut).subscribe(data => {
    console.log(data);
    this.router.navigate(["/classroom-list"]);
  },
  error=> console.log(error));
  }
}
