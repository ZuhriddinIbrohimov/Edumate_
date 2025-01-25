package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.CourseCreateDTO;
import zuhriddinscode.something.entity.CourseEntity;
import zuhriddinscode.something.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public CourseCreateDTO create(CourseCreateDTO dto) {
        CourseEntity entity = toEntity(dto);

        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private CourseEntity toEntity(CourseCreateDTO dto) {
        CourseEntity entity = new CourseEntity();
        entity.setTitle(dto.getTitle());
        entity.setPeriod(dto.getPeriod());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setCategoryId(dto.getCategoryId());

        return entity;
    }

}