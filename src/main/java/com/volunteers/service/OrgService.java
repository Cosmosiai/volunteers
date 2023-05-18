package com.volunteers.service;
import com.volunteers.entity.Job;
import com.volunteers.entity.Tag;
import com.volunteers.entity.User;
import com.volunteers.enums.JobS;
import com.volunteers.repos.UserRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class OrgService {
    Scanner scanner = new Scanner(System.in);

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

// Job related

//    public void createJob(Long id, String jobName, String jobDescription, String companyName, List<Tag> tag, JobS jobS) {
//        Job job = new Job(id, jobName, jobDescription, companyName, tag, jobS);
//    }

    public void changeJobName(@NotNull Job job, String name) {
        job.setJobName(name);
    }

    public void changeJobDescription(@NotNull Job job, String description) {
        job.setJobName(description);
    }

    public void changeJobTags(@NotNull Job job, List<Tag> tags) {
        job.setReqTags(tags);
    }

// Job status related
    public void activateJob(@NotNull Job job) {
        if (job.getJobStatus().equals(JobS.SUPERPAUSED) || job.getJobStatus().equals(JobS.SUPERDELETED)) {
            System.out.println("Failed, Job is stopped or deleted by administration, Please contact tech support");
        } else {
            job.setJobStatus(JobS.ACTIVE);
        }

    }

    public void pauseJob(@NotNull Job job) {
        job.setJobStatus(JobS.PAUSED);
    }

    public void endJob(@NotNull Job job) {
        for (User user:job.getConfirmedUsers()) {
            user.setJobsDone(+1);
        }
        job.setJobStatus(JobS.ENDED);
    }

    public void deleteJob(@NotNull Job job) {
        if (job.getAppliedUsers().size() > 0 && job.getConfirmedUsers().size() > 0) {
            job.setJobStatus(JobS.DELETED);
        } else {
            System.out.println("Failed, there are still applied/confirmed users to job");
        }

    }

// Other functions

    public void inviteUser(@NotNull Job job, User user) {
        if (!job.getInvitedUsers().contains(user)) {
            job.getInvitedUsers().add(job.getInvitedUsers().size() - 1, user);
        } else {
            System.out.println("Failed, User is already invited");
        }

    }

    public void confirmUser(@NotNull Job job, User user) {
        if (job.getAppliedUsers().contains(user) && !job.getConfirmedUsers().contains(user)) {
            job.getAppliedUsers().remove(user);
            job.getConfirmedUsers().add(job.getConfirmedUsers().size() - 1, user);
        } else if (!job.getAppliedUsers().contains(user)) {
            System.out.println("Failed, User has not applied to job");
        } else if (job.getConfirmedUsers().contains(user)) {
            System.out.println("Failed, User is already confirmed to job");
        }
    }

    public void cancelInvitedUser(@NotNull Job job, User user) {
        if (job.getInvitedUsers().contains(user)) {
            job.getInvitedUsers().remove(user);
        } else {
            System.out.println("Failed, User is not invited");
        }
    }

    public void cancelConfirmedUser(@NotNull Job job, User user) {
        if (job.getConfirmedUsers().contains(user)) {
            job.getConfirmedUsers().remove(user);
        } else {
            System.out.println("Failed, User is not confirmed");
        }
    }

    public void evaluateUser (@NotNull User user, int evaluation) {
        if (user.getJobsDone() != 0) {
            user.setReputation((user.getReputation() + evaluation) / user.getJobsDone());
        } else {
            user.setReputation(evaluation);
        }

    }
}
