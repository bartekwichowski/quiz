package quiz.mapper;
/**
 * Created by Bartlomiej Wichowski Date: 8/18/2018 Time: 10:03 AM
 */

import org.springframework.stereotype.Component;
import quiz.domain.Category;
import quiz.dto.CategoryDTO;
/**
 *
 */
@Component
public class CategoryMapper {

    public CategoryDTO toDto(Category category) {
        return new CategoryDTO() {{
            setId(category.getId());
            setName(category.getName());
        }};
    }
}
