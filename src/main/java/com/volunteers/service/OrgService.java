package com.volunteers.service;
import com.volunteers.entity.Organisation;
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

    public void findUser(String username) {
        User user = this.userRepo.findUserByUsername(username);
    }


// Other functions
    public void hireUser(Long id) {
    }

    public void evaluateUser(Long id) {
    }
}
