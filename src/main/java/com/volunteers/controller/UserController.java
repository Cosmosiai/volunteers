package com.volunteers.controller;

import com.volunteers.entity.Organisation;
import com.volunteers.entity.User;
import com.volunteers.service.OrgService;
import com.volunteers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    OrgService orgService;

// -------------------------------------------------- User functions --------------------------------------------------
// Find functions

    @PatchMapping(value = "/user-find-user-by-id")
    public User findUserById(@RequestParam Long id) {
        return userService.findUserById(id);
    }

    @PatchMapping(value = "/user-find-org-by-id")
    public Organisation findOrgById(@RequestParam Long id) {
        return userService.findOrgById(id);
    }

    @PatchMapping(value = "/user-find-user-by-username")
    public User findUser(@RequestParam String username) {
        return userService.findUser(username);
    }

    @PatchMapping(value = "/user-find-org-by-companyname")
    public Organisation findOrg(@RequestParam String companyName) {
        return userService.findOrg(companyName);
    }

// Other functions

    @PatchMapping(value = "/check-jobs")
    public Long checkJobs(@RequestParam Long id) {
        return userService.checkJobs(id);
    }
    @PatchMapping(value = "/apply-jobs")
    public Long applyJob(@RequestParam Long id) {
        return userService.applyJob(id);
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
