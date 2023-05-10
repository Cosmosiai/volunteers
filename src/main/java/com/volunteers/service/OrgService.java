package com.volunteers.service;
import com.volunteers.entity.User;
import com.volunteers.repos.OrgRepo;
import com.volunteers.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    @Autowired
    OrgRepo orgRepo;
    @Autowired
    UserRepo userRepo;

// -------------------------------------------------- Org functions --------------------------------------------------
// Find functions

    public User findUserById(Long id) {
        return this.userRepo.findUserByUserId(id);
    }

    public User findUser(String username) {
        return this.userRepo.findUserByUsername(username);
    }


// Other functions
    public void hireUser(Long id) {
    }

    public void evaluateUser(Long id) {
    }
}
