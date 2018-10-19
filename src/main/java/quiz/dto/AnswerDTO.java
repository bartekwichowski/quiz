package quiz.dto;
/**
 * Created by Bartlomiej Wichowski Date: 7/30/2018 Time: 5:54 PM
 */

/**
 *
 */
public class AnswerDTO {

    private Long id;

    private String answer;

    private Boolean correct;

    private Boolean chosen;

    private Long questionId;

    public AnswerDTO() {
    }

    public AnswerDTO(Long id, Long questionId, String answer) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
    }

    public AnswerDTO(Long id, Long questionId, String answer, Boolean correct) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.correct = correct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Boolean getChosen() {
        return chosen;
    }

    public void setChosen(Boolean chosen) {
        this.chosen = chosen;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
