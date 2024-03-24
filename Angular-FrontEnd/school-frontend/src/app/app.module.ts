import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { DeleteStudentComponent } from './delete-student/delete-student.component';
import { ClassroomListComponent } from './classroom-list/classroom-list.component';
import { StudentClassComponent } from './student-class/student-class.component';
import { JoinClassComponent } from './join-class/join-class.component';
import { OutClassComponent } from './out-class/out-class.component';
import { CreateSubjectComponent } from './create-subject/create-subject.component';
import { SubjectListComponent } from './subject-list/subject-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EditSubjectDialogComponent } from './edit-subject-dialog/edit-subject-dialog.component';
import { MatDialogModule} from "@angular/material/dialog";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    CreateStudentComponent,
    UpdateStudentComponent,
    DeleteStudentComponent,
    ClassroomListComponent,
    StudentClassComponent,
    JoinClassComponent,
    OutClassComponent,
    CreateSubjectComponent,
    SubjectListComponent,
    EditSubjectDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
