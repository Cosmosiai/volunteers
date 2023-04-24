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

    @PatchMapping(value = "/find-org-by-name")
    public void findUser(@RequestParam String username) {
        orgService.findUser(username);
    }
    @PatchMapping(value = "/hire-org-by-id")
    public void hireUser(@RequestParam Long id) {
        orgService.hireUser(id);
    }
    @PatchMapping(value = "/evaluate-org-by-id")
    public void evaluateUser(@RequestParam Long id) {
        orgService.evaluateUser(id);
    }

}
