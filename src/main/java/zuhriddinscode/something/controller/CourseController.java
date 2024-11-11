package zuhriddinscode.something.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import zuhriddinscode.something.entity.CourseEntity;
import zuhriddinscode.something.dto.CourseDTO;
import zuhriddinscode.something.exception.ResourceNotFoundException;
import zuhriddinscode.something.repository.CategoryRepository;
import zuhriddinscode.something.repository.CourseRepository;
import zuhriddinscode.something.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@Api(tags = "course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CategoryRepository categoryRepository;

//    // Categoriyadan type ga o'tishda
//    @GetMapping(value = "/getAllCourseByTypeId/{typeId}")
//    public ResponseEntity<?> getAllCourseByTypeId(@PathVariable("typeId") Integer typeId) {
//        List<CourseEntity> list = courseService.findCourseByType(typeId);
//        return ResponseEntity.ok(list);
//    }

//    @PostMapping(value = "/addCourse")
//    public ResponseEntity<?> addCourse(@RequestBody CourseDTO courseDTO) {
//        System.out.println(courseDTO);
//        CourseDTO courseDTO1 = courseService.add(courseDTO);
//        return ResponseEntity.ok(courseDTO1);
//    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        List<CourseEntity> list = courseService.getAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/categories/{categoryId}/courses")
    public ResponseEntity<CourseEntity> createCourse(@PathVariable(value = "categoryId") Integer categoryId,
                                                     @RequestBody CourseEntity courseRequest) {
        CourseEntity courseEntity = categoryRepository.findById(categoryId). map(category ->
        {
            courseRequest.setCategory(category);
            return courseRepository.save(courseRequest);
        }       ).orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + categoryId));
        return new ResponseEntity<>(courseEntity, HttpStatus.CREATED);
    }

//    @GetMapping(value = "/getCourseById")
//    public ResponseEntity<?> getCourseById(){
//
//        return ResponseEntity.ok();
//    }

}