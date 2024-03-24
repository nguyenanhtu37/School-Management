import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { AppComponent } from './app.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ClassroomListComponent } from './classroom-list/classroom-list.component';
import { StudentClassComponent } from './student-class/student-class.component';
import { JoinClassComponent } from './join-class/join-class.component';
import { OutClassComponent } from './out-class/out-class.component';
import {CreateSubjectComponent} from "./create-subject/create-subject.component";
import {SubjectListComponent} from "./subject-list/subject-list.component";

// cau hinh duong dan
const routes: Routes = [
  {path: "student-list", component: StudentListComponent },
  // khi truy cap duong dan `` se redirect den student-list
  {path:"", redirectTo:'student-list', pathMatch:'full'},
  {path:"create-student", component: CreateStudentComponent},
  {path:"update-student/:studentId", component: UpdateStudentComponent},
  {path: "classroom-list", component: ClassroomListComponent },
  {path: "student-class/:classId", component: StudentClassComponent },
  {path:"join-class", component: JoinClassComponent},
  {path:"out-class", component: OutClassComponent},
  {path:"create-subject", component: CreateSubjectComponent},
  {path:"subject-list", component: SubjectListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
