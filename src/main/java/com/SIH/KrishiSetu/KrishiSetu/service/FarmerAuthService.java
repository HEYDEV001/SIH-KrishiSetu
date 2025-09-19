package com.SIH.KrishiSetu.KrishiSetu.service;

import com.SIH.KrishiSetu.KrishiSetu.dto.FarmerDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.LoginDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.LoginResponseDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.SignUpDTO;
import com.SIH.KrishiSetu.KrishiSetu.entity.Farmer;
import com.SIH.KrishiSetu.KrishiSetu.repository.FarmerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FarmerAuthService {

    private final ModelMapper modelMapper;
    private final FarmerRepository farmerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public FarmerDTO signUp(SignUpDTO signUpDTO) {
        Optional<Farmer> user = farmerRepository.findByMobileNumber(signUpDTO.getMobileNumber());
        if (user.isPresent()) {
            throw new BadCredentialsException("User with this email" + signUpDTO.getEmail() + "is already present");
        }
        Farmer farmerToBeCreated = modelMapper.map(signUpDTO, Farmer.class);
        if(farmerToBeCreated.getPassword()==null||farmerToBeCreated.getPassword().isBlank()){
            throw new BadCredentialsException("Password is required");
        }
        farmerToBeCreated.setPassword(passwordEncoder.encode(farmerToBeCreated.getPassword()));
        Farmer savedUser = farmerRepository.save(farmerToBeCreated);
        return modelMapper.map(savedUser, FarmerDTO.class);
    }


    public LoginResponseDTO login(LoginDTO loginDTO) {
        Farmer farmerEntity = farmerRepository.findByMobileNumber(loginDTO.getMobileNumber())
                .orElseThrow(() -> new UsernameNotFoundException("Farmer not found"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), farmerEntity.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return new LoginResponseDTO(farmerEntity.getId(), farmerEntity.getName(), farmerEntity.getAge());
    }
}
