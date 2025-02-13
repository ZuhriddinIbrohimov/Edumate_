package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.AuthDTO;
import zuhriddinscode.something.dto.ProfileDTO;
import zuhriddinscode.something.dto.RegistrationDTO;
import zuhriddinscode.something.entity.ProfileEntity;
import zuhriddinscode.something.exception.AppBadException;
import zuhriddinscode.something.repository.ProfileRepository;
import zuhriddinscode.something.repository.ProfileRoleRepository;
import zuhriddinscode.something.types.GeneralStatus;
import zuhriddinscode.something.types.ProfileRole;
import zuhriddinscode.something.util.JwtUtil;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public String registration(RegistrationDTO dto) {
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

        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);

        //insert roles
        profileRoleService.create(entity.getId(), ProfileRole.ROLE_USER);
        return "Successfully registered";
    }

    public ProfileDTO login (AuthDTO authDTO) {
        // dto
        //check
        Optional<ProfileEntity> optional = profileRepository.findByUsername(authDTO.getUsername());
        if (optional.isEmpty()) {
            throw new AppBadException("Username or password wrong");
        }

        ProfileEntity profile = optional.get();
        if (!bCryptPasswordEncoder.matches(authDTO.getPassword(), profile.getPassword())) {
            throw new AppBadException("Username or password wrong");
        }

//        if (!profile.getStatus().equals(GeneralStatus.ACTIVE)) {
//            throw new AppBadException("Wrong Status");
//        }

        ProfileDTO response = new ProfileDTO();
        response.setName(profile.getName());
        response.setSurname(profile.getSurname());
        response.setRoleList(profileRoleRepository.getAllRolesListByProfileId(profile.getId()));
        response.setJwt(JwtUtil.encode(profile.getUsername() , profile.getId(), response.getRoleList() ));

        return response;
    }
}