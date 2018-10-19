package quiz.dto;
/**
 * Created by Bartlomiej Wichowski Date: 7/30/2018 Time: 5:53 PM
 */

import java.util.List;

/**
 *
 */
public class QuestionOptionsDTO {

    private String question;

    private List<AnswerDTO> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
