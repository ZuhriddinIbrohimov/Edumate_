package zuhriddinscode.something.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zuhriddinscode.something.dto.AuthDTO;
import zuhriddinscode.something.dto.ProfileDTO;
import zuhriddinscode.something.dto.RegistrationDTO;
import zuhriddinscode.something.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registration")
    public ResponseEntity <String> registration (@Valid @RequestBody RegistrationDTO dto){
        return ResponseEntity.ok().body ( authService.registration(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<ProfileDTO> login (@Valid @RequestBody AuthDTO authDTO){
       return ResponseEntity.ok().body ( authService.login(authDTO));
    }

}