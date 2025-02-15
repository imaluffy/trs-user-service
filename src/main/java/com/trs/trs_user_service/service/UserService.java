package com.trs.trs_user_service.service;

import com.trs.trs_user_service.model.User;
import com.trs.trs_user_service.model.UserDTO;
import com.trs.trs_user_service.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    ModelMapper modelMapper;


    public void save(UserDTO userDTO) {
        User user=modelMapper.map(userDTO, User.class);
        repo.save(user);
    }

    public UserDTO getUser(String email_id) {
        Optional<User> optional = repo.findByEmail(email_id);
        if(optional.isPresent()){
            UserDTO userDTO=modelMapper.map(optional.get(), UserDTO.class);
            return userDTO;
        }
        return null;
    }
}
