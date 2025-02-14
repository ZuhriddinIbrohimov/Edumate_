package zuhriddinscode.something.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zuhriddinscode.something.dto.teacher.TeacherDTO;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

// create, update, delete, search, getTeacher
// linkedin, facebook link
// teacher's details


    @RequestMapping
    public ResponseEntity <String> createTeacher(TeacherDTO dto){
       return ResponseEntity.ok().body("");
    }
}