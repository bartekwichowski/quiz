package quiz.dto;
/**
 * Created by Bartlomiej Wichowski Date: 8/18/2018 Time: 10:00 AM
 */

/**
 *
 */
public class CategoryDTO {

    private Long id;

    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
