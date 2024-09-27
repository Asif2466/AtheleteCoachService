package com.ust.AtheleteCoachService.controller;

import com.ust.AtheleteCoachService.dto.LoginDTO;
import com.ust.AtheleteCoachService.dto.RegisterDTO;
import com.ust.AtheleteCoachService.service.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/athlete/users")
@AllArgsConstructor
public class UserController {

    private UserServices userServices;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto){
        return ResponseEntity.ok(userServices.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO dto){
        return ResponseEntity.ok(userServices.register(dto));
    }

}
