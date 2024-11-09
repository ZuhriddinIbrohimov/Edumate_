package zuhriddinscode.something.service;

import zuhriddinscode.something.entity.CourseEntity;
import zuhriddinscode.something.dto.CourseDTO;

import java.util.List;

public interface ICourseService {

    CourseDTO add(CourseDTO courseDTO);
    List<CourseEntity> findCourseByType(Integer typeId);

    List<CourseEntity> getAll();

    }