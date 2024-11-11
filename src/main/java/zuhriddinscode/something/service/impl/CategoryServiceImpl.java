package zuhriddinscode.something.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.CategoryDTO;
import zuhriddinscode.something.entity.CategoryEntity;
import zuhriddinscode.something.repository.CategoryRepository;
import zuhriddinscode.something.service.ICategoryService;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Barcha kategoriyalarni olish
    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

//    // Kategoriyani ID bo'yicha olish
//    @Override
//    public CategoryEntity getCategoryById(Integer id) {
//        Optional<CategoryEntity> category = categoryRepository.findById(id);
//        return category.orElseThrow(() -> new RuntimeException("Kategoriyani topilmadi!"));
//    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

       CategoryEntity categoryEntity = new CategoryEntity();
       categoryEntity.setId(categoryDTO.getId());
       categoryEntity.setName(categoryDTO.getName());
       categoryRepository.save (categoryEntity);
       return categoryDTO;
    }

//    @Override
//    public CategoryEntity findById(Integer categoryId) {
//      CategoryEntity courseEntity =  categoryRepository.findById(categoryId);
//        return courseEntity;
//    }
}