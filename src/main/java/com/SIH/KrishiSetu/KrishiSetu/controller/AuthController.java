package com.SIH.KrishiSetu.KrishiSetu.controller;

import com.SIH.KrishiSetu.KrishiSetu.dto.FarmerDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.LoginDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.LoginResponseDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.SignUpDTO;
import com.SIH.KrishiSetu.KrishiSetu.service.FarmerAuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final FarmerAuthService farmerAuthService;

    @PostMapping("/signup")
    public ResponseEntity<FarmerDTO> signUp(@RequestBody SignUpDTO signUpDTO) {
        FarmerDTO newFarmerDTO = farmerAuthService.signUp(signUpDTO);
        return ResponseEntity.ok(newFarmerDTO);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO){
        LoginResponseDTO loginResponseDTO = farmerAuthService.login(loginDTO);
        return ResponseEntity.ok(loginResponseDTO);

    }

}
