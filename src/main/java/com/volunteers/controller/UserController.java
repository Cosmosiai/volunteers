package com.volunteers.controller;

import com.volunteers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

// -------------------------------------------------- User functions --------------------------------------------------
// Find functions

    @PatchMapping(value = "/find-user-by-id")
    public void findUserById(@RequestParam String username) {
        userService.findUser(username);
    }

    @PatchMapping(value = "/find-org-by-id")
    public void findOrgById(@RequestParam Long id) {
        userService.findOrgById(id);
    }

    @PatchMapping(value = "/find-user")
    public void findUser(@RequestParam String username) {
        userService.findUser(username);
    }

    @PatchMapping(value = "/find-org")
    public void findOrg(@RequestParam String companyName) {
        userService.findOrg(companyName);
    }

// Other functions

    @PatchMapping(value = "/check-jobs")
    public void checkJobs(@RequestParam Long id) {
    }
    @PatchMapping(value = "/apply-jobs")
    public void applyJob(@RequestParam Long id) {
    }

// -------------------------------------------------- Admin functions --------------------------------------------------
// User status Functions

    @PatchMapping(value = "/ban-user-by-id")
    public String ban(@RequestParam Long id) {
        userService.banUser(id);
        return "success";
    }

    @PatchMapping(value = "/activate-user-by-id")
    public String activateUser(@RequestParam Long id) {
        userService.activateUser(id);
        return "success";
    }

    @PatchMapping(value = "/admin-user-by-id")
    public String adminUser(@RequestParam Long id) {
        userService.adminUser(id);
        return "success";
    }

    @PatchMapping(value = "/delete-user-by-id")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "success";
    }
}
