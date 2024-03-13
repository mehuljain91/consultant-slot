package com.project.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.entity.Client;
import com.project.assignment.entity.Consultant;
import com.project.assignment.entity.User;
import com.project.assignment.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/clients")
    public ResponseEntity<User> registerClient(@RequestBody Client client) {
        User registeredUser = userService.registerClient(client);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/consultants")
    public ResponseEntity<User> registerConsultant(@RequestBody Consultant consultant) {
        User registeredUser = userService.registerConsultant(consultant);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

}
