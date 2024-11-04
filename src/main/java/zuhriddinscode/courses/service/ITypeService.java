package zuhriddinscode.courses.service;

import zuhriddinscode.courses.courseEntity.TypeEntity;
import zuhriddinscode.courses.courseDTO.Course;
import java.util.List;

public interface ITypeService {

    List <TypeEntity> findCourseByType(Integer typeId);
    Course add (Course course);

}