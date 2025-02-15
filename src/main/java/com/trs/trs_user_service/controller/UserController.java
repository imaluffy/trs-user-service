package com.trs.trs_user_service.controller;

import com.trs.trs_user_service.model.UserDTO;
import com.trs.trs_user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public void sendData(@RequestBody UserDTO user){
        System.out.println("Yo boy");
        service.save(user);

    }

    @GetMapping("/login/{email_id}")
    public ResponseEntity<?> getUserById(@PathVariable String email_id){
        UserDTO resp = service.getUser(email_id);
        if(resp != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resp);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not registered");
        }
    }
}
