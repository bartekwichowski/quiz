import { Component, OnInit, Input } from '@angular/core';
import { Question } from '../../model/question';
import { DataService } from '../data.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent {

  @Input()
  private questions: Question[];

  @Input()
  private numberOfCorrect: number = 0;

  @Input()
  private numberOfAll: number = 0;

  constructor() { }
}
