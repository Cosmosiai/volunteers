package com.volunteers.repos;

import com.volunteers.entity.Job;
import com.volunteers.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findUserByUserId(Long id);
    User findUserByUsername(String username);
    Job findAllJobs();
    Job findJobById(Long id);
}
