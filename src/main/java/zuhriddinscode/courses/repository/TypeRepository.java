package zuhriddinscode.courses.repository;

import zuhriddinscode.courses.courseEntity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<TypeEntity, Integer> {
    List<TypeEntity> findCourseByTypeId (int typeId);
}