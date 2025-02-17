package zuhriddinscode.something.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zuhriddinscode.something.entity.ProfileRoleEntity;
import zuhriddinscode.something.types.ProfileRole;
import java.util.List;

@Repository
public interface ProfileRoleRepository extends JpaRepository <ProfileRoleEntity, Integer> {

    @Query("select p.roles from ProfileRoleEntity p where p.profileId =?1")
    List<ProfileRole> getAllRolesListByProfileId (Integer profileId );

}