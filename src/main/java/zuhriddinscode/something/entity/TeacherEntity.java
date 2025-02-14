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

    private ProfileDTO user;

    @Column(name = "salary")
    private double salary;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column( name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
}