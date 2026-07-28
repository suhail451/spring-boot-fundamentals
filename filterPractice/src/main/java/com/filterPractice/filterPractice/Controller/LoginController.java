package com.filterPractice.filterPractice.Controller;

import com.filterPractice.filterPractice.Entity.RegisterEntity;
import com.filterPractice.filterPractice.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

   @GetMapping("/login")
    public String loginUser(@RequestBody RegisterEntity registerEntity){

         String token=loginService.loginUser(registerEntity);
         return "Access Token \n"+token;

}

}
