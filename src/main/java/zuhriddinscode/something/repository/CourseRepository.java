package zuhriddinscode.something.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import zuhriddinscode.something.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import zuhriddinscode.something.types.CourseStatus;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    Optional<CourseEntity> findById(Integer id);

    @Transactional
    @Modifying
    @Query("update CourseEntity set title =?1, description = ?2,"+
            "category.id=?3 where id =?4")
    int update( String title,
                String description,
                Integer categoryId,
                Integer id);
}