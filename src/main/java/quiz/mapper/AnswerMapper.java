package quiz.mapper;
/**
 * Created by Bartlomiej Wichowski Date: 7/30/2018 Time: 6:09 PM
 */

import org.springframework.stereotype.Component;
import quiz.domain.Answer;
import quiz.dto.AnswerDTO;

/**
 *
 */
@Component
public class AnswerMapper {

    public Answer toEntity(AnswerDTO answerDTO){
        return new Answer() {{
           setAnswer(answerDTO.getAnswer());
           setCorrect(answerDTO.getCorrect());
        }};
    }
}
