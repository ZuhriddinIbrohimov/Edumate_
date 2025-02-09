package zuhriddinscode.something.entity;

import jakarta.persistence.*;
import zuhriddinscode.something.types.GeneralStatus;
import zuhriddinscode.something.types.ProfileStatus;
import java.time.LocalDateTime;

@Entity
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "name" )
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name ="status")
    @Enumerated(EnumType.STRING)
    private GeneralStatus status;

    @Column(name = "visible")
    private Boolean visible;

    @Column( name ="created_date" )
    private LocalDateTime CreatedDate;


    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public GeneralStatus getStatus() {
        return status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        CreatedDate = createdDate;
    }

    //    @OneToMany (mappedBy = "profile")
//    private List<ProfileRoleEntity> roleList;

}