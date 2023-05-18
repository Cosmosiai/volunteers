package com.volunteers.service;

import com.volunteers.entity.Job;
import com.volunteers.entity.Organisation;
import com.volunteers.entity.User;
import com.volunteers.enums.JobS;
import com.volunteers.enums.UserS;
import com.volunteers.repos.JobRepo;
import com.volunteers.repos.OrgRepo;
import com.volunteers.repos.UserRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private OrgRepo orgRepo;
    private JobRepo jobRepo;

// -------------------------------------------------- User functions --------------------------------------------------
// Find functions

    public User findUserById(Long id) {
        return userRepo.findUserByUserId(id);
    }
    public User findUser(String username) {
        return this.userRepo.findUserByUsername(username);
    }

    public Organisation findOrgById(Long id) {
        return this.orgRepo.findOrgById(id);
    }

    public Organisation findOrg(String companyName) {
        return this.orgRepo.findByCompanyName(companyName);
    }

    public Job findJobById(Long id) {
        return this.jobRepo.findJobById(id);
    }

// Job related functions

    public void acceptJob() {

    }
    public void declineJob() {

    }

    public List<Job> checkJobs() {
        return this.jobRepo.findAll();
    }

    public void applyJob(@NotNull Job job, User user) {
        job.getAppliedUsers().add(user);
    }

// Other functions

    public User save(User user) {
        return this.userRepo.save(user);
    }

// -------------------------------------------------- Admin functions --------------------------------------------------
// Job status changing
    public void adminActivateJob(@NotNull Job job) {
        job.setJobStatus(JobS.ACTIVE);
    }

    public void adminPauseJob(@NotNull Job job) {
        job.setJobStatus(JobS.SUPERPAUSED);
    }

    public void adminDeleteJob(@NotNull Job job) {
        job.setJobStatus(JobS.SUPERDELETED);
    }

// User status Functions

    public void banUser(Long id) {
        User user = this.userRepo.findUserByUserId(id);
        if (user != null) {
            user.setStatus(UserS.BANNED);
            userRepo.save(user);
        }
    }

    public void activateUser(Long id) {
        User user = this.userRepo.findUserByUserId(id);
        if (user != null) {
            user.setStatus(UserS.ACTIVE);
            userRepo.save(user);
        }
    }

    public void adminUser(Long id) {
        User user = this.userRepo.findUserByUserId(id);
        if (user != null) {
            user.setStatus(UserS.ADMIN);
            userRepo.save(user);
        }
    }

    public void deleteUser(Long id) {
        User user = this.userRepo.findUserByUserId(id);
        if (user != null) {
            user.setStatus(UserS.DELETED);
            userRepo.save(user);
        }
    }



}
