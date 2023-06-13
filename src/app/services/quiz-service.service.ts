import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Quiz } from '../classes/quiz';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizServiceService {

  private quizUrl: string;

  constructor(private http: HttpClient) {
    this.quizUrl = 'http://localhost:8080/api/quiz/getAll';
  }

  public findAll(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(this.quizUrl);
  }
}
