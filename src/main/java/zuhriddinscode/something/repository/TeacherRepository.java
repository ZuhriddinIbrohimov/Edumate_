package zuhriddinscode.something.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zuhriddinscode.something.entity.TeacherEntity;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository <TeacherEntity, Integer> {

//    Optional<TeacherEntity> findByUsername( String username );


}