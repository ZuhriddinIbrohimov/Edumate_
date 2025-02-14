package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.ProfileDTO;
import zuhriddinscode.something.entity.ProfileEntity;
import zuhriddinscode.something.repository.ProfileRepository;
import zuhriddinscode.something.types.ProfileRole;

import java.time.LocalDateTime;

@Service
public class ProfileService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileRoleService profileRoleService;

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

    public String update(ProfileDTO dto) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        profileRepository.save(entity);
        return "1";
    }
}