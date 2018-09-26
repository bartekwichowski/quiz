export class Answer {
    id: number;
    answer: string;
    chosen: boolean = false;
    correct: boolean = false;

    constructor(answer: string) {
      this.answer = answer;
    }
}
