package zuhriddinscode.something.repository;

import zuhriddinscode.something.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    List<CourseEntity> findCourseByTypeId (int typeId);

}