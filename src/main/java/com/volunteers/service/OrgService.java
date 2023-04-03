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

    public void findOrgById(Long id) {
        Organisation org = this.orgRepo.findOrgById(id);
    }

    public void findUserById(Long id) {
        User user = this.userRepo.findUserById(id);
    }

    public void findUser(String username) {
        User user = this.userRepo.findUser(username);
    }

    public void findOrg(String companyName) {
        Organisation org = this.orgRepo.findOrg(companyName);
    }

// Other functions
    public void hireUser(Long id) {
    }

    public void evaluateUser(Long id) {
    }
}
