package WorkFind.courses.controller;

import WorkFind.courses.courseEntity.TypeEntity;
import WorkFind.courses.courseDTO.Course;
import WorkFind.courses.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class TypeController {

    @Autowired
    private ITypeService courseService;

    @GetMapping (value = "/getAllCourseByTypeId/{typeId}")
    public ResponseEntity <?> getAllCourseByTypeId ( @PathVariable ("typeId") Integer typeId) {
        List<TypeEntity> list = courseService.findCourseByType(typeId);
        return ResponseEntity.ok(list);
    }

    @PostMapping (value = "/addCourse")
    public ResponseEntity <?> addCourse ( @RequestBody Course course) {
        System.out.println(course);
        Course course1 = courseService.add(course) ;
        return ResponseEntity.ok(course1);
    }
}