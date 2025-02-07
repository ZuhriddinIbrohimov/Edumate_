package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.course.CourseCreateDTO;
import zuhriddinscode.something.dto.course.CourseDTO;
import zuhriddinscode.something.entity.CourseEntity;
import zuhriddinscode.something.exception.ItemNotFoundException;
import zuhriddinscode.something.repository.CourseRepository;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private CategoryService categoryService;

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

    public CourseDTO getById(Integer id) {
        Optional<CourseEntity> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Course not found");
        }
        CourseEntity entity = optional.get();
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setPeriod(entity.getPeriod());
        dto.setCategory( categoryService.getById (entity.getCategoryId()) );
        return dto;
    }

    public int update ( CourseDTO dto, Integer id ){
        get(id);
        return repository.update(dto.getTitle(),dto.getDescription(),dto.getCategoryId(),id);
    }

    private void get( Integer id ){
        repository.findById(id).orElseThrow(()-> { throw new ItemNotFoundException("Not found"); });
    }

    public Boolean delete(Integer id){
        get(id);
        int i = repository.delete(id);
        return i == 1;
    }


}