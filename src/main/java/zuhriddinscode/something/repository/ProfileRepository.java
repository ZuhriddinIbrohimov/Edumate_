package zuhriddinscode.something.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zuhriddinscode.something.entity.ProfileEntity;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository <ProfileEntity, String> {

    Optional<ProfileEntity> findByIdAndVisibleTrue (Integer id);
    Optional<ProfileEntity> findByUsernameAndVisibleTrue (String username);
    ProfileEntity deleteByUsername (String username );
}