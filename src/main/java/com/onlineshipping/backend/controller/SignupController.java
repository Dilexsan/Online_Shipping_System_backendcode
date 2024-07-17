package com.onlineshipping.backend.controller;


import com.onlineshipping.backend.model.Signup;
import com.onlineshipping.backend.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @PostMapping("/signup")
    Signup newSignup(@RequestBody Signup newSignup){

        return signupRepository.save(newSignup);
    }

    @GetMapping("/signups")
    List<Signup> getAllSignup(){

        return signupRepository.findAll();
    }


}
