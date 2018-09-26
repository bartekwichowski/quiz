package quiz.quizback.repository;
/**
 * Created by Bartlomiej Wichowski Date: 7/28/2018 Time: 1:54 AM
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import quiz.quizback.domain.Answer;
import quiz.quizback.dto.AnswerDTO;

import java.util.List;
import java.util.Set;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("SELECT new quiz.quizback.dto.AnswerDTO(a.id, q.id, a.answer) " +
            "FROM Answer a JOIN a.question q WHERE q.id = :questionId")
    List<AnswerDTO> getAnswersByQuestionId(@Param("questionId") Long questionId);

    @Query("SELECT new quiz.quizback.dto.AnswerDTO(a.id, q.id, a.answer, a.correct) " +
            "FROM Answer a JOIN a.question q WHERE q.id = :questionId")
    List<AnswerDTO> getAllAnswersByQuestionId(@Param("questionId") Long questionId);

    @Query("SELECT new quiz.quizback.dto.AnswerDTO(a.id, q.id, a.answer, a.correct) " +
            "FROM Answer a JOIN a.question q WHERE q.id IN :questions")
    Set<AnswerDTO> getCorrectAnswersForQuestions(@Param("questions") Set<Long> questions);
}
