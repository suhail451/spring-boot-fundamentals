package com.filterPractice.filterPractice.Controller;


import com.filterPractice.filterPractice.Entity.RegisterEntity;
import com.filterPractice.filterPractice.Service.RegisterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("register")
    public String registerUser(@RequestBody RegisterEntity registerEntity){

        return registerService.registerStudent(registerEntity)+" Registerd successfully";


    }


}
