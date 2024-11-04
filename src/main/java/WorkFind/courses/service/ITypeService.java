package WorkFind.courses.service;

import WorkFind.courses.courseEntity.TypeEntity;
import WorkFind.courses.courseDTO.Course;
import java.util.List;

public interface ITypeService {

    List <TypeEntity> findCourseByType(Integer typeId);
    Course add (Course course);

}