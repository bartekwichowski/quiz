import { Component, Input, OnChanges } from '@angular/core';
import { Question } from './../../model/question';
import { Answer } from '../../model/answer';
import { DataService } from '../data.service';
@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnChanges {

  @Input()
  private question: Question;

  constructor(private dataService: DataService) { }

  ngOnChanges() {
    this.loadData();
  }

  loadData() {
    console.log('Question answers: ' + this.question.answers);
    if (this.question.answers == null) {
      this.dataService.getAnswerByQuestionId(this.question.id).subscribe((answers: Answer[])  => {
        console.log(answers);
        this.question.answers = answers;
      });
    }
  }

  setAnswer(answer) {
    // console.log(answer);
    const index = this.question.answers.indexOf(answer, 0);
    this.question.answers[index] = answer;
  }
}
