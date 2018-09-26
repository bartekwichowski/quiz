import { Component, OnInit } from '@angular/core';
import { Question } from '../../model/question';
import { DataService } from '../data.service';
import { Result } from '../../model/result';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  private questions: Question[] = [Question.emptyQuestion()];
  private index = 0;
  private isQuiz = true;
  private numberOfCorrect: number;
  private numberOfAll: number;

  constructor(private dataService: DataService) { }

  getIndex(): number {
    return this.index;
  }

  ngOnInit() {
    this.loadQuestions();
  }

  loadQuestions() {
    this.dataService.getQuestions().subscribe(
      (questions: Question[])  => this.questions = questions);
  }

  prev() {
    if (this.index === 0) {
      this.index = this.questions.length;
    }
    this.index--;
  }

  next() {
    this.index++;
    this.index = this.index % this.questions.length;
  }

  submit() {
    this.isQuiz = false;
    this.dataService.checkQuiz(this.questions).subscribe(
      (result: Result) => {
        this.questions = result.questions;
        this.numberOfCorrect = result.numberOfCorrect;
        this.numberOfAll = result.numberOfAll;

      }
    );


    console.log(JSON.stringify(this.questions));
  }

  reset() {
    // this.questions = [];
    // this.numberOfCorrect = 0;
    // this.numberOfAll = 0;
    this.isQuiz = true;
    // this.loadQuestions();
  }

}
