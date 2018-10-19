package quiz.dto;
/**
 * Created by Bartlomiej Wichowski Date: 8/10/2018 Time: 10:27 PM
 */

import java.util.List;

/**
 *
 */
public class ResultDTO {

    private Integer numberOfCorrect;

    private Integer numberOfAll;

    private List<QuestionDTO> questions;

    public ResultDTO(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public Integer getNumberOfCorrect() {
        return numberOfCorrect;
    }

    public void setNumberOfCorrect(Integer numberOfCorrect) {
        this.numberOfCorrect = numberOfCorrect;
    }

    public Integer getNumberOfAll() {
        return numberOfAll;
    }

    public void setNumberOfAll(Integer numberOfAll) {
        this.numberOfAll = numberOfAll;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
