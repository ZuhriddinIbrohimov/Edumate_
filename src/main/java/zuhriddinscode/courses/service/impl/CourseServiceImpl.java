package zuhriddinscode.courses.service.impl;

import zuhriddinscode.courses.courseEntity.CourseEntity;
import zuhriddinscode.courses.courseDTO.CourseDTO;
import zuhriddinscode.courses.repository.CourseRepository;
import zuhriddinscode.courses.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements ICourseService {

    private static List<CourseDTO> courseDTOList = new ArrayList<>();

    @Autowired
    CourseRepository repository;

    @Override
    public List <CourseEntity> findCourseByType(Integer typeId) {
        List <CourseEntity> list = repository.findCourseByTypeId(typeId);
        return list;
    }

    @Override
    public CourseDTO add(CourseDTO courseDTO) {
        courseDTOList.add(courseDTO);

        CourseEntity entity = new CourseEntity();
        entity.setName(courseDTO.getName());
        entity.setTypeId(courseDTO.getTypeId());
        entity.setPeriod(courseDTO.getPeriod());
        entity.setPrice(courseDTO.getPrice());
        repository.save(entity);
        return courseDTO;
    }

    @Override
    public List<CourseEntity> getAll() {
        List <CourseEntity> list = repository.findAll();
        return list;
    }

}