package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.entity.CourseEntity;
import zuhriddinscode.something.dto.CourseDTO;
import zuhriddinscode.something.repository.CourseRepository;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    CourseDTO create(CourseDTO courseDTO){
    CourseEntity entity = toEntity(courseDTO);
        repository.save(entity);
        return courseDTO;
    }

    List<CourseEntity> getAll(){
        List <CourseEntity> list = repository.findAll();
        return list;
    }

    private CourseEntity toEntity( CourseDTO dto ){
        CourseEntity entity = new CourseEntity();
        entity.setName(dto.getName());
        entity.setPeriod(dto.getPeriod());
        entity.setPrice(dto.getPrice());
        return entity;
    }

}