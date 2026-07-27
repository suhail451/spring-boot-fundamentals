package com.filterPractice.filterPractice.Service;

import com.filterPractice.filterPractice.Entity.RegisterEntity;
import com.filterPractice.filterPractice.Repository.RegisterRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    final RegisterRepo registerRepo;
    final PasswordEncoder passwordEncoder;

    public RegisterService(RegisterRepo registerRepo, PasswordEncoder passwordEncoder) {
        this.registerRepo = registerRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public String registerStudent(RegisterEntity registerEntity){

        String encodedPass=passwordEncoder.encode(registerEntity.getPassword());

        RegisterEntity myEntity=new RegisterEntity(registerEntity.getName(),registerEntity.getRole(),encodedPass);

                registerRepo.save(myEntity);
        return registerEntity.getName();
    }



}
