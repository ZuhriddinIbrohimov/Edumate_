package zuhriddinscode.courses.service;

import zuhriddinscode.courses.courseEntity.CourseEntity;
import zuhriddinscode.courses.courseDTO.CourseDTO;

import java.util.List;

public interface ICourseService {

    List<CourseEntity> findCourseByType(Integer typeId);

    CourseDTO add(CourseDTO courseDTO);

    List<CourseEntity> getAll();
}