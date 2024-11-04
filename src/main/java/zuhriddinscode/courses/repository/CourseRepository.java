package zuhriddinscode.courses.repository;

import zuhriddinscode.courses.courseEntity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    List<CourseEntity> findCourseByTypeId (int typeId);

}