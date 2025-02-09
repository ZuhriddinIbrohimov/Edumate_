package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.RegistrationDTO;
import zuhriddinscode.something.entity.ProfileEntity;
import zuhriddinscode.something.repository.ProfileRepository;
import zuhriddinscode.something.repository.ProfileRoleRepository;
import zuhriddinscode.something.types.ProfileRole;

import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileRoleRepository profileRoleRepository;

    @Autowired
    private ProfileRoleService profileRoleService;

    public String registration ( RegistrationDTO dto ) {
//        Optional<ProfileEntity> optional = profileRepository.findByUsername(dto.getUsername());
//        if ( optional.isPresent( ) ) {
//            throw new AppBadException ( "Username already exists" );
//        }
//        ProfileEntity profileEntity = optional.get();
//

//        if ( profileEntity. ) {
//        }
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode ( dto.getPassword()) );
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);

        //insert roles
        profileRoleService.create(entity.getId(), ProfileRole.ROLE_USER);
        return "Successfully registered" ;
    }
}