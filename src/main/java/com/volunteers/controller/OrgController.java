package com.volunteers.controller;

import com.volunteers.service.OrgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgController {

    @Autowired
    OrgService orgService;

    @PatchMapping(value = "/find-user")
    public void findUser(@RequestParam String username) {
        orgService.findUser(username);
    }
    @PatchMapping(value = "/hire-user-by-id")
    public void hireUser(@RequestParam Long id) {
        orgService.hireUser(id);
    }
    @PatchMapping(value = "/evaluate-user-by-id")
    public void evaluateUser(@RequestParam Long id) {
        orgService.evaluateUser(id);
    }

}
