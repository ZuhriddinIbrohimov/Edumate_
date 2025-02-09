package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.entity.ProfileRoleEntity;
import zuhriddinscode.something.repository.ProfileRoleRepository;
import zuhriddinscode.something.types.ProfileRole;


import java.time.LocalDateTime;

@Service
public class ProfileRoleService {

    @Autowired
    private ProfileRoleRepository profileRoleRepository;

    public void create (Integer profileId, ProfileRole profileRole ){
        //insert roles
        ProfileRoleEntity entity = new ProfileRoleEntity();
        entity.setProfileId(entity.getId());
        entity.setRoles(ProfileRole.ROLE_USER);
        entity.setCreatedDate(LocalDateTime.now());
        profileRoleRepository.save(entity);
    }

}