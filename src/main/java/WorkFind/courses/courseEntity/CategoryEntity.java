package WorkFind.courses.courseEntity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name ="type")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "type_id")   // many tomonda create type
    private List<TypeEntity> typeList;



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

    public List<TypeEntity> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeEntity> typeList) {
        this.typeList = typeList;
    }
}