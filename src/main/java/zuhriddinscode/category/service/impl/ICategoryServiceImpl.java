package zuhriddinscode.category.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.category.categoryDTO.CategoryDTO;
import zuhriddinscode.category.entity.CategoryEntity;
import zuhriddinscode.category.repository.CategoryRepository;
import zuhriddinscode.category.service.ICategoryService;
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
       CategoryEntity entity = new CategoryEntity();
       entity.setName(categoryDTO.getName());
       entity.setId(categoryDTO.getId());
       categoryRepository.save(entity);
       return categoryDTO;
    }
}