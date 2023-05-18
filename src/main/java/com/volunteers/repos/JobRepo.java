package com.volunteers.repos;

import com.volunteers.entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends CrudRepository<Job, Long> {
    List<Job> findAll();
    Job findJobById(Long id);
}
