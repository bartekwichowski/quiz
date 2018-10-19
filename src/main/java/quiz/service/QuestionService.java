package quiz.service;
/**
 * Created by Bartlomiej Wichowski Date: 7/30/2018 Time: 5:56 PM
 */
import quiz.dto.AnswerDTO;
import quiz.dto.CategoryDTO;
import quiz.dto.QuestionDTO;
import quiz.dto.ResultDTO;

import java.util.List;

/**
 *
 */
public interface QuestionService {

    void createQuestion(QuestionDTO questionDTO);

    List<QuestionDTO> getQuestions();

    List<AnswerDTO> getAnswersByQuestionId(Long questionId);

    ResultDTO checkQuiz(List<QuestionDTO> questions);

    QuestionDTO getQuestion(Long questionId);

    List<CategoryDTO> getCategories();

    CategoryDTO getCategory(Long categoryId);

    void delete(Long questionId);
}
