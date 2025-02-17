package zuhriddinscode.something.dto.teacher;

import org.springframework.format.annotation.DateTimeFormat;
import zuhriddinscode.something.dto.ProfileDTO;
import java.util.Date;

public class TeacherDTO {

    private int id;
//    private ProfileDTO user;
    private double salary;
    private String description;
    private String name;
    private String surname;
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

//    public ProfileDTO getUser() {
//        return user;
//    }
//
//    public void setUser(ProfileDTO user) {
//        this.user = user;
//    }

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
}