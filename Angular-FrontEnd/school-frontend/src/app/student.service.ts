import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
import { ResponesObject } from './respones-object';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseURL ="http://localhost:8080/student/print";
  private baseURL1 ="http://localhost:8080/student/add";
  private baseURL2 ="http://localhost:8080/student/get";
  private baseURL3 ="http://localhost:8080/student/update";
  private baseURL4 ="http://localhost:8080/student/delete";

  constructor(private httpClient: HttpClient) {
   }

  getStudentsList() : Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }

  createStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.baseURL1}`,student)
  }

getStudentById(studentId: number):Observable<ResponesObject>{
  return this.httpClient.get<ResponesObject>(`${this.baseURL2}/${studentId}`);
}

updateStudent(studentId: number, student: Student):Observable<Object>{
  return this.httpClient.put<Student>(`${this.baseURL3}/${studentId}`,student);
}

deleteStudent(studentId: number):Observable<Student[]>{
  return this.httpClient.get<Student[]>(`${this.baseURL4}/${studentId}`);
}
}
