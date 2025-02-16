package zuhriddinscode.something.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zuhriddinscode.something.dto.teacher.TeacherDTO;
import zuhriddinscode.something.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

// create, update, delete, search, getTeacher
// linkedin, facebook link
// teacher's details

    @Autowired
    private TeacherService teacherService;

    @RequestMapping
    public ResponseEntity <String> createTeacher (TeacherDTO dto){
       return ResponseEntity.ok().body(teacherService.create(dto));
    }




}