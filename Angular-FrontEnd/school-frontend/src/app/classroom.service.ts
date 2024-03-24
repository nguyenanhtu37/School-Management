import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Classroom } from './classroom';
import { Student } from './student';
import { ResponesObject } from './respones-object';

@Injectable({
  providedIn: 'root'
})
export class ClassroomService {
  private baseURL ="http://localhost:8080/classroom/print";
  private baseURL1 ="http://localhost:8080/classroom/inclass";
  private baseURL2 ="http://localhost:8080/classfuction/join";
  private baseURL3 ="http://localhost:8080/classfuction/moveout";

  constructor(private httpClient: HttpClient) {
  }

  getClassroomList() : Observable<Classroom[]>{
    return this.httpClient.get<Classroom[]>(`${this.baseURL}`);
  }

  getStudentinClass(classId: string):Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL1}/${classId}`);
  }

joinStudent(classId: string, studentId: number):Observable<Object>{

  let params = new HttpParams()
    .set("classId", classId)
    .set("studentId", studentId);
return this.httpClient.get<Object>(this.baseURL2,{params:params})

}
outStudent(classId: string, studentId: number):Observable<Object>{
  let params = new HttpParams()
    .set("classId", classId)
    .set("studentId", studentId);
return this.httpClient.get<Object>(this.baseURL3,{params:params})

}


}
