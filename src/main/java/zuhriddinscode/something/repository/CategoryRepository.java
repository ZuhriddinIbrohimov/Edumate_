package zuhriddinscode.something.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zuhriddinscode.something.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}