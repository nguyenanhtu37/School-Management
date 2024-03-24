import {Component, OnInit} from '@angular/core';
import {SubjectService} from "../subject.service";
import {response} from "express";

@Component({
  selector: 'app-create-subject',
  templateUrl: './create-subject.component.html',
  styleUrl: './create-subject.component.css',
  providers: [SubjectService]
})
export class CreateSubjectComponent implements OnInit{
  constructor(private subjectService: SubjectService) {
  }

  ngOnInit(): void {
  }
  // subjectid:string='';
  subjectname:string='';
  subjectdescription:string='';
  classroomclassid:string='';

  submitHandler(d:any){
    console.log("Data: ", d);
    // console.log("Subject Name = ", this.subjectname);
    // console.log("Subject Description = ", this.subjectdescription);
    // console.log("Class No. = ", this.classno);
    this.subjectService.addSubject(d).subscribe(response => {
      console.log("Data is saved successfully!", response);
      }, error => {
      console.error("Failed when trying to save data!", error);
      }
    )
  }
}
