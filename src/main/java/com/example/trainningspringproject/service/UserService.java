package com.example.trainningspringproject.service;

import com.example.trainningspringproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkIfUserExists(int id){
        boolean exists =  userRepository.existsById(id);
        if(!exists){
            return false;
        }
        return true;
    }

}
