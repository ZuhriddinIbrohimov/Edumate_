package zuhriddinscode.category.entity;

import jakarta.persistence.*;
import zuhriddinscode.courses.courseEntity.CourseEntity;

import java.util.List;

@Entity
@Table(name ="category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany()
    @JoinColumn(name = "category_id")   // many tomonda create type
    private List<CourseEntity> courses;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }
}