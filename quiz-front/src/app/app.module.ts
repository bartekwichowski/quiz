import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { QuestionListComponent } from './question-list/question-list.component';
import { QuestionComponent } from './question/question.component';
import { AnswerComponent } from './answer/answer.component';
import { ResultComponent } from './result/result.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { QuizComponent } from './quiz/quiz.component';
import { QuestionViewComponent } from './question-view/question-view.component';
import { QuestionEditComponent } from './question-edit/question-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionListComponent,
    QuestionComponent,
    AnswerComponent,
    ResultComponent,
    HomeComponent,
    QuizComponent,
    QuestionViewComponent,
    QuestionEditComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        component: QuizComponent,
        path: 'quiz'
      },
      {
        component: QuestionListComponent,
        path: 'questions'
      },
      {
        component: QuestionViewComponent,
        path: 'question/:id'
      },
      {
        component: QuestionEditComponent,
        path: 'question-edit/:id'
      },
      {
        component: QuestionEditComponent,
        path: 'question-edit'
      },
      {
        component: HomeComponent,
        path: ''
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
