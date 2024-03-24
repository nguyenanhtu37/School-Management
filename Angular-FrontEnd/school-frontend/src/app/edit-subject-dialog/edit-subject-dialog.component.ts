import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-subject-dialog',
  templateUrl: './edit-subject-dialog.component.html',
  styleUrls: ['./edit-subject-dialog.component.css']
})
export class EditSubjectDialogComponent {
  editForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<EditSubjectDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fb: FormBuilder
  ) {
    this.editForm = this.fb.group({
      subjectName: [data.subjectName, Validators.required],
      subjectDescription: [data.subjectDescription, Validators.required],
      classroomClassId: [data.classroomClassId, Validators.required],
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
