package quiz.quizback.repository;
/**
 * Created by Bartlomiej Wichowski Date: 8/18/2018 Time: 10:05 AM
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quiz.quizback.domain.Category;
import quiz.quizback.dto.CategoryDTO;

import java.util.List;

/**
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT DISTINCT new quiz.quizback.dto.CategoryDTO(c.id, c.name) " +
            "FROM Category c")
    List<CategoryDTO> getAllCategories();
}