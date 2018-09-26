package quiz.quizback.mapper;
/**
 * Created by Bartlomiej Wichowski Date: 7/30/2018 Time: 6:03 PM
 */

import org.springframework.stereotype.Component;
import quiz.quizback.domain.Question;
import quiz.quizback.dto.QuestionDTO;

/**
 *
 */
@Component
public class QuestionMapper {

    public QuestionDTO toDto(Question question) {
        return new QuestionDTO() {{
            setId(question.getId());
            setQuestion(question.getQuestion());
            setCategoryId(question.getCategory().getId());
        }};
    }

}
