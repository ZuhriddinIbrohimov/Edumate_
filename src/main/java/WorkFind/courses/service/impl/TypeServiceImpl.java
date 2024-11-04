package WorkFind.courses.service.impl;

import WorkFind.courses.courseEntity.TypeEntity;
import WorkFind.courses.courseDTO.Course;
import WorkFind.courses.repository.TypeRepository;
import WorkFind.courses.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseService")
public class TypeServiceImpl implements ITypeService {

    private static List<Course> courseList = new ArrayList<>();

    @Autowired
    TypeRepository repository;

    @Override
    public List <TypeEntity> findCourseByType(Integer typeId) {
        List <TypeEntity> list = repository.findCourseByTypeId(typeId);
        return list;
    }

    @Override
    public Course add(Course course) {
        courseList.add(course);

        TypeEntity entity = new TypeEntity();
        entity.setName(course.getName());
        entity.setTypeId(course.getTypeId());
        entity.setPeriod(course.getPeriod());
        entity.setPrice(course.getPrice());
        repository.save(entity);
        return course;
    }
}