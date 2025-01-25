package zuhriddinscode.something.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import zuhriddinscode.something.dto.CourseCreateDTO;
import zuhriddinscode.something.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/moderator/create")
    public ResponseEntity<?> create (@Valid @RequestBody CourseCreateDTO dto){
        CourseCreateDTO response = courseService.create(dto);
        return ResponseEntity.ok(response);
    }

}