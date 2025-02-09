package zuhriddinscode.something.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zuhriddinscode.something.entity.ProfileEntity;
import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository <ProfileEntity, String> {

    Optional<ProfileEntity> findByUsernameAndVisibleTrue (String username);

}