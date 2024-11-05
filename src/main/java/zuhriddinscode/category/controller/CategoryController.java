package zuhriddinscode.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuhriddinscode.category.categoryDTO.CategoryDTO;
import zuhriddinscode.category.entity.CategoryEntity;
import zuhriddinscode.category.service.ICategoryService;
import zuhriddinscode.courses.courseEntity.CourseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    // Barcha kategoriyalarni olish
    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Kategoriyani ID bo‘yicha olish va o'sha kategoriya bo'yicha kurslarni ko'rsatish
    @GetMapping("/{id}/courses")
    public List<CourseEntity> getCoursesByCategory (@PathVariable Integer id) {
        return categoryService.getCategoryById(id).getCourses();
    }

    @PostMapping(value = "/addCategory")
    public ResponseEntity<?> addCourse (@RequestBody CategoryDTO categoryDTO) {
      CategoryDTO categoryDTO1 = categoryService.addCategory(categoryDTO);
      return ResponseEntity.ok(categoryDTO1);
    }
}