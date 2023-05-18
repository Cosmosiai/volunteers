package com.volunteers.service;

import com.volunteers.entity.Tag;
import com.volunteers.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonAuthService {

    public User createUser(String username, String password, String firstname, String lastname, List<Tag> tags) {
        return new User(username, password, firstname, lastname, tags);
    }
}
