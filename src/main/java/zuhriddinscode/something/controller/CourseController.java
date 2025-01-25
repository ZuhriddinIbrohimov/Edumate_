package zuhriddinscode.something.controller;

import io.swagger.annotations.Api;
import zuhriddinscode.something.repository.CategoryRepository;
import zuhriddinscode.something.repository.CourseRepository;
import zuhriddinscode.something.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@Api(tags = "course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CategoryRepository categoryRepository;

}