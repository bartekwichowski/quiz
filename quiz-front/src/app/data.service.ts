import { Injectable } from '@angular/core';
import { Answer } from '../model/answer';
import { Question } from '../model/question';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/index';
import { Result } from '../model/result';
import { Category } from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getQuestions() : Observable<Question[]> {
    return this.http.get<Question[]>('/api/questions');
  }

  getAnswerByQuestionId(questionId: number) {
    return this.http.get<Answer[]>('/api/answers/' + questionId);
  }

  checkQuiz(questions: Question[]) {
    return this.http.post<Result>('/api/result', questions);
  }

  getQuestion(questionId: number) : Observable<Question> {
    return this.http.get<Question>('/api/question/' + questionId);
  }

  createQuestion(question: Question) {
    return this.http.post<Question>('/api/question', question);
  }

  getCategories() : Observable<Category[]> {
    return this.http.get<Category[]>('/api/categories');
  }

  getCategory(categoryId: number) : Observable<Category> {
    return this.http.get<Category>('/api/category/' + categoryId);
  }

  deleteQuestion(questionId: number) : Observable<any> {
    return this.http.delete<void>('/api/question/' + questionId);
  }
}
