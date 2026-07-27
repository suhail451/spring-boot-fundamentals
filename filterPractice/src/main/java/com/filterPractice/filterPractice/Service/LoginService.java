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


    public LoginService(RegisterRepo registerRepo, PasswordEncoder passwordEncoder) {
        this.registerRepo = registerRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean loginUser(RegisterEntity registerEntity){

        RegisterEntity user=registerRepo.findByName(registerEntity.getName());

        if(!passwordEncoder.matches(registerEntity.getPassword(),user.getPassword())){
               return false;
        }

        return true;

    }

}
