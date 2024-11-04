package zuhriddinscode.courses.controller;

import zuhriddinscode.courses.courseEntity.CourseEntity;
import zuhriddinscode.courses.courseDTO.CourseDTO;
import zuhriddinscode.courses.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    // Categoriyadan type ga o'tishda
    @GetMapping(value = "/getAllCourseByTypeId/{typeId}")
    public ResponseEntity<?> getAllCourseByTypeId(@PathVariable("typeId") Integer typeId) {
        List<CourseEntity> list = courseService.findCourseByType(typeId);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody CourseDTO courseDTO) {
        System.out.println(courseDTO);
        CourseDTO courseDTO1 = courseService.add(courseDTO);
        return ResponseEntity.ok(courseDTO1);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        List<CourseEntity> list = courseService.getAll();
        return ResponseEntity.ok(list);
    }
}