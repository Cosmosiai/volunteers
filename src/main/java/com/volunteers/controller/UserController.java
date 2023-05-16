package com.volunteers.controller;

import com.volunteers.entity.Job;
import com.volunteers.entity.Organisation;
import com.volunteers.entity.User;
import com.volunteers.service.OrgService;
import com.volunteers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/user-find-user-by-id")
    public User findUserById(@RequestParam Long id) {
        return userService.findUserById(id);
    }

    @GetMapping(value = "/user-find-org-by-id")
    public Organisation findOrgById(@RequestParam Long id) {
        return userService.findOrgById(id);
    }

    @GetMapping(value = "/user-find-user-by-username")
    public User findUser(@RequestParam String username) {
        return userService.findUser(username);
    }

    @GetMapping(value = "/user-find-org-by-companyname")
    public Organisation findOrg(@RequestParam String companyName) {
        return userService.findOrg(companyName);
    }

    @GetMapping(value = "/find-job")
    public Job findJobById(Long id) {
        return userService.findJobById(id);
    }

// Other functions

    @GetMapping(value = "/check-jobs")
    public Job checkJobs() {
        return userService.checkJobs();
    }

    @GetMapping(value = "/apply-jobs")
    public void applyJob(@RequestParam Job job, User user) {
        userService.applyJob(job, user);
        System.out.println("Success_message");
    }

// -------------------------------------------------- Admin functions --------------------------------------------------
// Job status changing
    @GetMapping(value = "/admin-activate-job")
    public void adminActivateJob(Job job) {
        userService.adminActivateJob(job);
    }

    @GetMapping(value = "/admin-pause-job")
    public void adminPauseJob(Job job) {
        userService.adminPauseJob(job);
    }

    @GetMapping(value = "/admin-delete-job")
    public void adminDeleteJob(Job job) {
        userService.adminDeleteJob(job);
    }

// User status Functions

    @GetMapping(value = "/ban-user-by-id")
    public String ban(@RequestParam Long id) {
        userService.banUser(id);
        return "success";
    }

    @GetMapping(value = "/activate-user-by-id")
    public String activateUser(@RequestParam Long id) {
        userService.activateUser(id);
        return "success";
    }

    @GetMapping(value = "/admin-user-by-id")
    public String adminUser(@RequestParam Long id) {
        userService.adminUser(id);
        return "success";
    }

    @GetMapping(value = "/delete-user-by-id")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "success";
    }
}
