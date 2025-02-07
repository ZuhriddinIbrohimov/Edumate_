package zuhriddinscode.something.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column( name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();    // category  name qachon biriktirilgan

    public Integer getId( ) {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

}