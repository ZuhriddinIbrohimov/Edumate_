package zuhriddinscode.something.service;

import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.ProfileDTO;
import zuhriddinscode.something.dto.teacher.TeacherDTO;
import zuhriddinscode.something.entity.ProfileEntity;
import zuhriddinscode.something.entity.TeacherEntity;
import zuhriddinscode.something.repository.ProfileRoleRepository;
import zuhriddinscode.something.repository.TeacherRepository;
import zuhriddinscode.something.types.ProfileRole;
import java.time.LocalDateTime;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ProfileRoleService profileRoleService;

    public String create(TeacherDTO dto) {
        TeacherEntity entity = new TeacherEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setCreatedDate(LocalDateTime.now());
        teacherRepository.save(entity);

        // insert roles
        profileRoleService.create(entity.getId(), ProfileRole.ROLE_ADMIN);
        return "Successfully registered";
    }
}