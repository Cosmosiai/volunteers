package com.volunteers.controller;

import com.volunteers.entity.User;
import com.volunteers.service.OrgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgController {

    @Autowired
    OrgService orgService;

// Find functions

    @PatchMapping(value = "/org-find-user-by-id")
    public User findUser(@RequestParam Long id) {
        return orgService.findUserById(id);
    }

    @PatchMapping(value = "/org-find-user-by-username")
    public User findUser(@RequestParam String username) {
        return orgService.findUser(username);
    }

//Other

    @PatchMapping(value = "/hire-user-by-id")
    public void hireUser(@RequestParam Long id) {
        orgService.hireUser(id);
    }

    @PatchMapping(value = "/evaluate-user-by-id")
    public void evaluateUser(@RequestParam Long id) {
        orgService.evaluateUser(id);
    }

}
