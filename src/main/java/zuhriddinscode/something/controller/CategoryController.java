package zuhriddinscode.something.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuhriddinscode.something.dto.CategoryDTO;
import zuhriddinscode.something.repository.CategoryRepository;
import zuhriddinscode.something.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/admin")
    public ResponseEntity<?> create(@Valid @RequestBody CategoryDTO dto){
        return ResponseEntity.ok(categoryService.create(dto));
    }


}