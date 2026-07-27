package com.filterPractice.filterPractice.Service;

import com.filterPractice.filterPractice.Entity.RegisterEntity;
import com.filterPractice.filterPractice.GlobalException.StudentNotFound;
import com.filterPractice.filterPractice.Repository.RegisterRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {


     final RegisterRepo registerRepo;
     final PasswordEncoder passwordEncoder;
     final JwtService jwtService;


    public LoginService(RegisterRepo registerRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.registerRepo = registerRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String loginUser(RegisterEntity registerEntity){

        RegisterEntity user=registerRepo.findByName(registerEntity.getName());
        if (user == null) {
            throw new StudentNotFound("User not found");
        }
        if(!passwordEncoder.matches(registerEntity.getPassword(),user.getPassword())){
               return "password incorrect";
        }

         return jwtService.generateToken(registerEntity.getName());


    }

}
