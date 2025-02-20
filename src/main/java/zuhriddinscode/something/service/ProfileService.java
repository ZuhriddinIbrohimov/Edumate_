package zuhriddinscode.something.service;

import io.jsonwebtoken.security.Jwks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.ProfileDTO;
import zuhriddinscode.something.entity.ProfileEntity;
import zuhriddinscode.something.exception.AppBadException;
import zuhriddinscode.something.repository.ProfileRepository;
import zuhriddinscode.something.types.ProfileRole;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileRoleService profileRoleService;

    public ProfileEntity getById( int id ){
//        Optional<ProfileEntity> optional = profileRepository.findByIdAndVisibleTrue(id);
//        if ( optional.isEmpty() ){
//            throw new AppBadException("Profile Not Found");
//        }

        return profileRepository.findByIdAndVisibleTrue(id).orElseThrow(()-> {
            throw new AppBadException("Profile Not Found");
        });
    }

    public String createAdmin(ProfileDTO dto) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);

        // insert roles
        profileRoleService.create(entity.getId(), ProfileRole.ROLE_ADMIN);
        return "Successfully registered";
    }

    // update admin
    public String update(ProfileDTO dto) {
        get(dto);

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        profileRepository.save(entity);
        return "1";
    }

    protected ProfileEntity get(ProfileDTO dto) {
        return profileRepository.findByUsernameAndVisibleTrue(dto.getUsername()).orElseThrow(() -> new AppBadException("Profile not found"));
    }

    public String delete (ProfileDTO dto){
//        get(dto);
        profileRepository.deleteByUsername(dto.getUsername());
        return "deleted successfully";
    }

//    public

}