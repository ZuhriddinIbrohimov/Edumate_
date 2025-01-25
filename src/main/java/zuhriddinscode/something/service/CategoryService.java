package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.CategoryDTO;
import zuhriddinscode.something.entity.CategoryEntity;
import zuhriddinscode.something.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDTO create(CategoryDTO categoryDTO)
    {
        CategoryEntity categoryEntity = toEntity(categoryDTO);
        categoryRepository.save(categoryEntity);
        categoryDTO.setId(categoryEntity.getId());
    return categoryDTO;
    }

    private CategoryEntity toEntity ( CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        // nameuz, nameru, name en, created date , visible
        return entity;
    }
}