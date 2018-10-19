package quiz.repository;
/**
 * Created by Bartlomiej Wichowski Date: 7/28/2018 Time: 1:54 AM
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quiz.domain.Question;
import quiz.dto.QuestionDTO;

import java.util.List;

/**
 *
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {


    @Query("SELECT new quiz.dto.QuestionDTO(q.id, q.question, c.id) " +
            "FROM Question q JOIN q.category c")
    List<QuestionDTO> getQuestionsWithCategory();

    @Query("SELECT new quiz.dto.QuestionDTO(q.id, q.question, c.id) " +
            "FROM Question q JOIN q.category c")
    List<QuestionDTO> getQuestionsFull();

}