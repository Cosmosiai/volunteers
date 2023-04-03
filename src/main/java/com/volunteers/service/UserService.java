package com.volunteers.service;

import com.volunteers.entity.Organisation;
import com.volunteers.entity.User;
import com.volunteers.enums.Statuses;
import com.volunteers.repos.OrgRepo;
import com.volunteers.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private OrgRepo orgRepo;

// -------------------------------------------------- User functions --------------------------------------------------
// Find functions

    public void findUserById(Long id) {
        User user = this.userRepo.findUserById(id);
    }

    public void findOrgById(Long id) {
        Organisation org = this.orgRepo.findOrgById(id);
    }

    public void findUser(String username) {
        User user = this.userRepo.findUser(username);
    }

    public void findOrg(String companyName) {
        Organisation org = this.orgRepo.findOrg(companyName);
    }

// Other functions

    public void checkJobs(Long id) {
    }

    public void applyJob(Long id) {
    }

    public void save(User user) {
        this.userRepo.save(user);
    }

// -------------------------------------------------- Admin functions --------------------------------------------------
// User status Functions

    public void banUser(Long id) {
        User user = this.userRepo.findUserById(id);
        if (user != null) {
            user.setStatus(Statuses.BANNED);
            userRepo.save(user);
        }
    }

    public void activateUser(Long id) {
        User user = this.userRepo.findUserById(id);
        if (user != null) {
            user.setStatus(Statuses.ACTIVE);
            userRepo.save(user);
        }
    }

    public void adminUser(Long id) {
        User user = this.userRepo.findUserById(id);
        if (user != null) {
            user.setStatus(Statuses.ADMIN);
            userRepo.save(user);
        }
    }

    public void deleteUser(Long id) {
        User user = this.userRepo.findUserById(id);
        if (user != null) {
            user.setStatus(Statuses.DELETED);
            userRepo.save(user);
        }
    }
}
