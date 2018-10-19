package quiz.mapper;
/**
 * Created by Bartlomiej Wichowski Date: 7/30/2018 Time: 6:03 PM
 */

import org.springframework.stereotype.Component;
import quiz.domain.Question;
import quiz.dto.QuestionDTO;

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
