import { Component, OnInit } from '@angular/core';
import { Answer } from '../../model/answer';
import { DataService } from '../data.service';
import { Question } from '../../model/question';
import { Category } from '../../model/category';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-question-edit',
  templateUrl: './question-edit.component.html',
  styleUrls: ['./question-edit.component.css']
})
export class QuestionEditComponent implements OnInit {

  private question: Question = Question.emptyQuestion();

  private selectUndefinedOptionValue:any;

  private categories: Category[];

  constructor(private dataService: DataService, private activatedRoute: ActivatedRoute, private router: Router,
              private location: Location) {
    this.question.answers = [];
  }

  ngOnInit() {
    this.dataService.getCategories().subscribe((categories: Category[]) => {
        this.categories = categories;
        console.log(JSON.stringify(this.categories));
    },() => {})

    console.log(this.activatedRoute.snapshot.params);

    const v = this.activatedRoute.snapshot.params['id'];
    if (v) {
      console.log('edit');
      this.dataService.getQuestion(v).subscribe((question: Question) => {
        this.question = question;
        console.log(question);
      })
    } else {
      console.log('new');
    }
  }

  addItem(newAnswer: string) {
    console.log('newAnswer ' + newAnswer);
    this.question.answers.push(new Answer(newAnswer));
  }

  deleteItem(index) {
    console.log('delete ' + index);
    if (index > -1) {
      this.question.answers.splice(index, 1);
    }
  }

  updateAnswer(index) {
    console.log('index' + index);
    this.question.answers[index].correct = !this.question.answers[index].correct;
  }

  addQuestion() {
    console.log(JSON.stringify(this.question));
    this.dataService.createQuestion(this.question).subscribe(() => {});
    this.router.navigate(['questions']);
  }

  goBack() {
    this.location.back();
  }
}
