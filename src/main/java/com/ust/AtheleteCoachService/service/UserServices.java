package com.ust.AtheleteCoachService.service;

import com.ust.AtheleteCoachService.dto.LoginDTO;
import com.ust.AtheleteCoachService.dto.RegisterDTO;
import com.ust.AtheleteCoachService.model.UserRole;
import com.ust.AtheleteCoachService.model.Users;
import com.ust.AtheleteCoachService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServices {

    private UserRepository userRepository;

    public String login(LoginDTO dto){

        Optional<Users> user = userRepository.findByUsername(dto.username());
        if(user.isPresent()){
            if(user.get().getPassword().equals(dto.password())){
                return "Login successfully";
            }
            else{
                return "Incorrect password";
            }
        }
        else {
            return "User not found";
        }
    }

    public String register(RegisterDTO dto){

        Optional<Users> user = userRepository.findByUsername(dto.username());
        if(user.isPresent()){
            return "User already present.....";
        }
        else{
            if(dto.password().equals(dto.confirmPassword())){
                Users user1 = new Users();
                user1.setUsername(dto.username());
                user1.setPassword(dto.password());
                user1.setUserRole(dto.role());
                userRepository.save(user1);
            }
        }
        return "Registered Successfully..";
    }

}
