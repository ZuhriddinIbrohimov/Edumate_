package zuhriddinscode.something.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import zuhriddinscode.something.entity.ProfileRoleEntity;
import zuhriddinscode.something.types.ProfileRole;
import java.util.List;

public interface ProfileRoleRepository extends CrudRepository<ProfileRoleEntity, Integer> {

    @Query("select p.roles from ProfileRoleEntity p where p.profileId =?1")
    List<ProfileRole> getAllRolesListByProfileId (Integer profileId );

}