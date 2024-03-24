import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import { Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SubjectListService {
  private apiUrl = 'http://localhost:8080/api/subjects';

  constructor(private http : HttpClient) { }
  getAllSubjects(): Observable<any[]>{
    return this.http.get<any[]>(`${this.apiUrl}`)
  }

  deleteSubjectWithId(id:number): Observable<any>{
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }

  editSubject(subjectId:number, newData: any): Observable<any>{
    return this.http.put<any>(`${this.apiUrl}/${subjectId}`, newData);
  }

  updateSubject(subjectId: number, updatedSubject: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${subjectId}`, updatedSubject);
  }
}
