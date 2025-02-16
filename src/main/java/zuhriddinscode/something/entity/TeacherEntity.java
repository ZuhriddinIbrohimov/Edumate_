package zuhriddinscode.something.entity;

import jakarta.persistence.*;
import zuhriddinscode.something.dto.ProfileDTO;
import java.time.LocalDateTime;

@Entity
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user")
    private ProfileDTO user;

    @Column(name = "salary")
    private double salary;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column( name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "name")
    private String surname;

    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProfileDTO getUser() {
        return user;
    }

    public void setUser(ProfileDTO user) {
        this.user = user;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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