package zuhriddinscode.something.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuhriddinscode.something.dto.ProfileDTO;
import zuhriddinscode.something.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/create")
    public ResponseEntity<String> createAdminAccount(@RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.ok().body(profileService.createAdmin(profileDTO));
    }

    @PutMapping("/")
    public ResponseEntity<String> updateAdmin(ProfileDTO profileDTO) {
        return ResponseEntity.ok().body(profileService.update(profileDTO));
    }
}