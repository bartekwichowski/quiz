import { Component, OnChanges, OnInit } from '@angular/core';
import { Question } from '../../model/question';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { mergeMap } from 'rxjs/internal/operators';
import { Location } from '@angular/common';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit, OnChanges{

  private questions: Question[] = [Question.emptyQuestion()];

  constructor(private dataService: DataService, private router: Router, private location: Location) { }

  ngOnInit() {
    this.loadQuestions();
  }

  ngOnChanges() {
    this.loadQuestions();
  }

  loadQuestions() {
    this.dataService.getQuestions().subscribe(
      (questions: Question[])  => this.questions = questions);
  }

  viewQuestion(questionId: number) {
    this.router.navigate(['question/' + questionId]).then();
  }

  deleteQuestion(questionId: number) {
    this.dataService.deleteQuestion(questionId).pipe(
      mergeMap(
        () => this.dataService.getQuestions()
      )
    ).subscribe((questions: Question[])  => this.questions = questions);
  }

}
