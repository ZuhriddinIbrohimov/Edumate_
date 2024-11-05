package zuhriddinscode.category.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.category.categoryDTO.CategoryDTO;
import zuhriddinscode.category.entity.CategoryEntity;
import zuhriddinscode.category.repository.CategoryRepository;
import zuhriddinscode.category.service.ICategoryService;
import zuhriddinscode.courses.courseDTO.CourseDTO;
import zuhriddinscode.courses.courseEntity.CourseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ICategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Barcha kategoriyalarni olish
    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Kategoriyani ID bo'yicha olish
    @Override
    public CategoryEntity getCategoryById(Integer id) {
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new RuntimeException("Kategoriyani topilmadi!"));
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
       CategoryEntity categoryEntity = new CategoryEntity();
       categoryEntity.setId(categoryDTO.getId());
       categoryEntity.setName(categoryDTO.getName());

       if ( categoryDTO.getCourses() != null){
           List<CourseEntity> courseEntityList = new ArrayList<>();
           for ( CourseDTO courseDTO :categoryDTO.getCourses()){

               CourseEntity courseEntity = new CourseEntity();
               courseEntity.setName( courseDTO.getName() );
               courseEntity.setCategory(categoryEntity);

               courseEntityList.add(courseEntity);
           }

           categoryEntity.setCourses(courseEntityList);
       }
       categoryRepository.save (categoryEntity);
       return categoryDTO;
    }
}