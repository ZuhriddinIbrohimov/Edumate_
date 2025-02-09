package zuhriddinscode.something.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import zuhriddinscode.something.dto.course.CourseCreateDTO;
import zuhriddinscode.something.dto.course.CourseDTO;
import zuhriddinscode.something.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/moderator/create")
    public ResponseEntity<?> create(@Valid @RequestBody CourseCreateDTO dto) {
        CourseCreateDTO response = courseService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/moderator/{id}")
    public ResponseEntity<?> getById (@PathVariable("id") Integer id){
        CourseDTO response = courseService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping ("/moderator/update")
    public ResponseEntity<?> update (@Valid @RequestBody CourseDTO dto, @RequestParam ("id") Integer id ){
        int response = courseService.update(dto,id);
        if (response == 1) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping ( "/moderator/delete" )
    public ResponseEntity <?> delete(@RequestParam("id") Integer id) {
        Boolean response = courseService.delete(id);
        return ResponseEntity.ok (response);
    }
}