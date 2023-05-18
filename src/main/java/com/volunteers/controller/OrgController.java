package com.volunteers.controller;

import com.volunteers.entity.Tag;
import com.volunteers.entity.User;
import com.volunteers.enums.JobS;
import com.volunteers.service.OrgService;
import com.volunteers.entity.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class OrgController {

    Scanner sc = new Scanner(System.in);

    @Autowired
    OrgService orgService;

// Find functions

    @GetMapping(value = "/org-find-user-by-id")
    public User findUser(@RequestParam Long id) {
        return orgService.findUserById(id);
    }

    @GetMapping(value = "/org-find-user-by-username")
    public User findUser(@RequestParam String username) {
        return orgService.findUser(username);
    }

// Job related

//    @GetMapping(value = "/create-job")
//    public void createJob(Long id, String jobName, String jobDescription, String companyName, List<Tag> tag, JobS jobS) {
//        orgService.createJob(id, jobName, jobDescription, companyName, tag, jobS);
//    }

    @GetMapping(value = "/change-job-name")
    public void changeJobName(Job job, String name) {
        orgService.changeJobName(job, name);
    }

    @GetMapping(value = "/change-job-description")
    public void changeJobDescription(Job job, String description) {
        orgService.changeJobDescription(job, description);
    }

    @GetMapping(value = "/change-job-tags")
    public void changeJobTags(Job job, List<Tag> tags) {
        orgService.changeJobTags(job, tags);
    }

// Job status
    @GetMapping(value = "/activate-job")
    public void activateJob(Job job) {
        orgService.activateJob(job);
    }

    @GetMapping(value = "/pause-job")
    public void pauseJob(Job job) {
        orgService.pauseJob(job);
    }

    @GetMapping(value = "/end-job")
    public void endJob(Job job) {
        orgService.endJob(job);
    }

    @GetMapping(value = "/delete-job")
    public void deleteJob(Job job) {
        orgService.deleteJob(job);
    }

// User interaction related

    @GetMapping(value = "/invite-user")
    public void inviteUser(@RequestParam Job job, User user) {
        orgService.inviteUser(job, user);
    }

    @GetMapping(value = "/confirm-user")
    public void confirmUser(@RequestParam Job job, User user) {
        orgService.confirmUser(job, user);
    }

    @GetMapping(value = "/cancel-invited-user")
    public void cancelInvitedUser(@RequestParam Job job, User user) {
        orgService.cancelInvitedUser(job, user);
    }

    @GetMapping(value = "/cancel-confirmed-user")
    public void cancelConfirmedUser(@RequestParam Job job, User user) {
        orgService.cancelConfirmedUser(job, user);
    }

    @GetMapping(value = "/evaluate-user-by-id")
    public void evaluateUser(@RequestParam User user, int evaluation) {
        orgService.evaluateUser(user, evaluation);
    }

}
