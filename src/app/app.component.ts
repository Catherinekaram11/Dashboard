import { Component, OnInit } from '@angular/core';
import { QuizServiceService } from './services/quiz-service.service';
import { Quiz } from './classes/quiz';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {
    quizzes !: Quiz[];
    quizService! : QuizServiceService;

    ngOnInit(): void{
    this.quizService.findAll().subscribe(data => {
                 this.quizzes = data;})}
    }
