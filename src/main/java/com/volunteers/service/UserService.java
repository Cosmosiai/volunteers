package com.volunteers.service;

import com.volunteers.entity.Organisation;
import com.volunteers.entity.User;
import com.volunteers.enums.UserS;
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

    public User findUserById(Long id) {
        return userRepo.findUserByUserId(id);
    }

    public Organisation findOrgById(Long id) {
        return this.orgRepo.findOrgById(id);
    }

    public User findUser(String username) {
        return this.userRepo.findUserByUsername(username);
    }

    public Organisation findOrg(String companyName) {
        return this.orgRepo.findByCompanyName(companyName);
    }

// Other functions

    public Long checkJobs(Long id) {
        return id;
    }

    public Long applyJob(Long id) {
        return id;
    }

    public User save(User user) {
        return this.userRepo.save(user);
    }

// -------------------------------------------------- Admin functions --------------------------------------------------
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
