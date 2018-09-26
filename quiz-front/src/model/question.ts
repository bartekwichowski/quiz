import { Answer } from './answer';
import { Category } from './category';

export class Question {

  id: number;
  question: string;
  categoryId: number;
  answers: Answer[];

  constructor(id: number, question: string, categoryId: number, answers: Answer[]) {
    this.id = id;
    this.question = question;
    this.categoryId = categoryId;
    this.answers = answers;
  }

  static emptyQuestion(): Question {
    return new Question(1, null, 1, []);
  }
}
