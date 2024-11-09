package zuhriddinscode.something.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuhriddinscode.something.dto.CategoryDTO;
import zuhriddinscode.something.entity.CategoryEntity;
import zuhriddinscode.something.entity.CourseEntity;
import zuhriddinscode.something.service.ICategoryService;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Api(tags = "Category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    // Barcha kategoriyalarni olish
    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

//     Kategoriyani ID bo‘yicha olish va o'sha kategoriya bo'yicha kurslarni ko'rsatish
//    @GetMapping("/{id}/courses")
//    public List<CourseEntity> getCoursesByCategory (@PathVariable Integer id) {
//        return categoryService.getCategoryById(id).getCourses();
//    }

    @PostMapping(value = "/addCategory")
    public ResponseEntity<?> addCourse (@RequestBody CategoryDTO categoryDTO) {
      CategoryDTO categoryDTO1 = categoryService.addCategory(categoryDTO);
      return ResponseEntity.ok(categoryDTO1);
    }
}