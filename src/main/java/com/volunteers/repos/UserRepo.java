package com.volunteers.repos;

import com.volunteers.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findUserById(Long id);
    User findUser(String username);
}
