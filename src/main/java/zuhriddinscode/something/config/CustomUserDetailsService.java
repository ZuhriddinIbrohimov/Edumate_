package zuhriddinscode.something.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.entity.ProfileEntity;
import zuhriddinscode.something.repository.ProfileRepository;
import zuhriddinscode.something.repository.ProfileRoleRepository;
import zuhriddinscode.something.types.ProfileRole;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ProfileRoleRepository profileRoleRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ProfileEntity> optional = profileRepository.findByUsernameAndVisibleTrue(username);
        if (optional.isEmpty()){
           throw new UsernameNotFoundException(username);
        }
        ProfileEntity profile = optional.get();
        List<ProfileRole> roleList = profileRoleRepository.getAllRolesListByProfileId(profile.getId());
        return new CustomUserDetails (profile, roleList );
    }
}