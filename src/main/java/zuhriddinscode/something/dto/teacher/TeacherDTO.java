package zuhriddinscode.something.dto.teacher;

import org.springframework.format.annotation.DateTimeFormat;
import zuhriddinscode.something.dto.ProfileDTO;
import java.util.Date;

public class TeacherDTO {

    private int id;
    private ProfileDTO user;
    private double salary;
    private String description;
    private String name;

}