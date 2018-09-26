package quiz.quizback.rest;
/**
 * Created by Bartlomiej Wichowski Date: 7/29/2018 Time: 3:56 AM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz.quizback.dto.AnswerDTO;
import quiz.quizback.dto.CategoryDTO;
import quiz.quizback.dto.QuestionDTO;
import quiz.quizback.dto.QuestionOptionsDTO;
import quiz.quizback.service.QuestionService;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/api")
public class QuizResource {

    @Autowired
    private QuestionService questionService;

    @GetMapping("questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions() {
        return new ResponseEntity(questionService.getQuestions(), HttpStatus.OK);
    }

    @GetMapping("answers/{questionId}")
    public ResponseEntity<AnswerDTO> getSonarInstance(@PathVariable Long questionId) {
        return new ResponseEntity(questionService.getAnswersByQuestionId(questionId), HttpStatus.OK);
    }

    @PostMapping("result")
    public ResponseEntity<String> checkQuiz(@RequestBody List<QuestionDTO> questions) {
        return new ResponseEntity(questionService.checkQuiz(questions), HttpStatus.OK);
    }

    @GetMapping("question/{questionId}")
    public ResponseEntity<QuestionDTO> getQuestion(@PathVariable Long questionId) {
        return new ResponseEntity(questionService.getQuestion(questionId), HttpStatus.OK);
    }

    @PostMapping("question")
    public void createNewQuestion(@RequestBody QuestionDTO question) {
        questionService.createQuestion(question);
    }

    @GetMapping("categories")
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        return new ResponseEntity(questionService.getCategories(), HttpStatus.OK);
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long categoryId) {
        return new ResponseEntity(questionService.getCategory(categoryId), HttpStatus.OK);
    }

    @DeleteMapping("question/{questionId}")
    public ResponseEntity<Void> delete(@PathVariable Long questionId) {
        questionService.delete(questionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
