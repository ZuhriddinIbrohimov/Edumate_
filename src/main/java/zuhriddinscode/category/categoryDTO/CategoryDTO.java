package zuhriddinscode.category.categoryDTO;

import zuhriddinscode.courses.courseDTO.CourseDTO;
import zuhriddinscode.courses.courseEntity.CourseEntity;
import java.util.List;

public class CategoryDTO {

    private Integer id;

    private String name;

    private List<CourseDTO> courses;

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}