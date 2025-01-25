package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.CategoryDTO;
import zuhriddinscode.something.entity.CategoryEntity;
import zuhriddinscode.something.repository.CategoryRepository;

import java.time.LocalDateTime;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO create(CategoryDTO dto) {
        CategoryEntity entity = toEntity(dto);

        categoryRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private CategoryEntity toEntity(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCreatedDate(LocalDateTime.now());
        // nameuz, nameru, name en, created date , visible
        return entity;
    }
}