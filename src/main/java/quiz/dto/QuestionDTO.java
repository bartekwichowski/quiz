package quiz.dto;
/**
 * Created by Bartlomiej Wichowski Date: 7/30/2018 Time: 5:59 PM
 */

import java.util.List;

/**
 *
 */
public class QuestionDTO {

    private Long id;

    private String question;

    private Long categoryId;

    private List<AnswerDTO> answers;

    public QuestionDTO() {
    }

    public QuestionDTO(Long id, String question, Long categoryId) {
        this.id = id;
        this.question = question;
        this.categoryId = categoryId;
    }

    public QuestionDTO(Long id, String question, Long categoryId, List<AnswerDTO> answers) {
        this.id = id;
        this.question = question;
        this.categoryId = categoryId;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
