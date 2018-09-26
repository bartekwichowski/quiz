import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';
import { Question } from '../../model/question';
import { mergeMap } from 'rxjs/internal/operators';
import { Category } from '../../model/category';
import { Location } from '@angular/common';

@Component({
  selector: 'app-question-view',
  templateUrl: './question-view.component.html',
  styleUrls: ['./question-view.component.css']
})
export class QuestionViewComponent implements OnInit {

  private question: Question;
  private category: Category;

  constructor(private dataService: DataService, private activatedRoute: ActivatedRoute, private location: Location) { }

  goBack() {
    this.location.back();
  }

  ngOnInit() {
    this.activatedRoute.params.pipe(
      mergeMap((params) => {
          return this.dataService.getQuestion(params['id']);
        }
      ),
      mergeMap(
        (question: Question) => {
          this.question = question;
          return this.dataService.getCategory(question.categoryId);
        })
      ).subscribe(
        (category: Category) => {
          this.category = category;
        }
      )
  }
}
