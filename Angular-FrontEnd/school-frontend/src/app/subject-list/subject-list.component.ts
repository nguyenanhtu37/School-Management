import { Component, OnInit } from '@angular/core';
import { SubjectListService } from '../subject-list.service';
import {error} from "console";
import {FormBuilder, FormGroup, Validator, Validators} from "@angular/forms";
import { MatDialog } from '@angular/material/dialog';
import { EditSubjectDialogComponent } from '../edit-subject-dialog/edit-subject-dialog.component';

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
  styleUrls: ['./subject-list.component.css']
})
export class SubjectListComponent implements OnInit {
  data: any[] = [];
  editForm: FormGroup;

  constructor(
    private subjectListService: SubjectListService,
    private fb: FormBuilder,
    private dialog: MatDialog
  ) {
    this.editForm = this.fb.group({
      subjectName: ['', Validators.required],
      subjectDescription: ['', Validators.required],
      classroomClassId: ['', Validators.required],
    });
  }

  ngOnInit() {
    this.loadData();
  }

  loadData(): void {
    this.subjectListService.getAllSubjects().subscribe(
      (response: any[]) => {
        this.data = response;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  // editItem(item: any): void {
  //   const subjectId = item.subjectId;
  //   this.editForm.patchValue({
  //     subjectName: item.subjectName,
  //     subjectDescription: item.subjectDescription,
  //     classroomClassId: item.classroomClassId,
  //   });
  // }
  //   submitEdit(): void{
  //   const subjectId = ;
  //   const newData = this.editForm.value;
  //
  //   this.subjectListService.editSubject(subjectId, newData).subscribe(
  //     () => {
  //       console.log(`Subject with ID ${subjectId} edited successfully!`);
  //       this.loadData();
  //     },
  //     (error) => {
  //       console.error(`Error editing subject with ID ${subjectId}:`, error);
  //     }
  //   );
  // }

  // getUpdatedData(item: any): any {
  //   return {
  //     subjectName: item.subjectName + "_Updated",
  //     subjectDescription: ,
  //     classroomClassId: item.classroomClassId,
  //     // Add other fields as needed
  //   };
  // }


  deleteItem(item: any): void {
    const subjectId = item.subjectId;

    this.subjectListService.deleteSubjectWithId(subjectId).subscribe(
      () => {
        // Subject deleted successfully, update the list.
        console.log(`Subject with ID ${subjectId} deleted successfully.`);
        this.loadData();
      },
      (error) => {
        console.error(`Error deleting subject with ID ${subjectId}:`, error);
      }
    );
  }

  editItem(item: any): void {
    const dialogRef = this.dialog.open(EditSubjectDialogComponent, {
      width: '400px', // Set the width as per your requirement
      data: item
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        // User clicked Save in the dialog, handle the result
        const subjectId = item.subjectId;
        const newData = result;

        this.subjectListService.editSubject(subjectId, newData).subscribe(
          () => {
            console.log(`Subject with ID ${subjectId} edited successfully!`);
            this.loadData();
          },
          (error) => {
            console.error(`Error editing subject with ID ${subjectId}:`, error);
          }
        );
      }
    });
  }

}
