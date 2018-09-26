import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Answer } from '../../model/answer';

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css']
})
export class AnswerComponent {

  @Input()
  answer: Answer;

  @Output()
  chosen: EventEmitter<Answer> = new EventEmitter();

  constructor() {}

  clickedAnswer() {
    this.answer.chosen = !this.answer.chosen;
    this.chosen.emit(this.answer);
  }

  getColor() {
    if (this.answer.correct) {
      return '#bbff99';
    } else if (this.answer.chosen) {
      return '#99ccff';
    } else {
      return 'white';
    }
  }
}
