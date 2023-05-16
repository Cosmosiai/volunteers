package com.volunteers.controller;

import com.volunteers.entity.Tag;
import com.volunteers.entity.User;
import com.volunteers.service.NonAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NonAuthController {

    @Autowired
    NonAuthService nonAuthService;

// --------------------------------------------- functions made by nonAuth---------------------------------------------

    @GetMapping(value = "/create-user")
    public User createUser(@RequestParam String username, String password, String firstname, String lastname, List<Tag> tags) {
        return nonAuthService.createUser(username, password, firstname, lastname, tags);
    }


}
