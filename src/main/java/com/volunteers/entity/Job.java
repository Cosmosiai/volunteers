package com.volunteers.entity;

import com.volunteers.enums.JobS;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "JOBS")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "jobName")
    private String jobName;

    @Column(name = "jobDescription")
    private String jobDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyName")
    private String companyName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "reqTags")
    private List<Tag> reqTags;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "invitedUsers")
    private List<User> invitedUsers;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "appliedUsers")
    private List<User> appliedUsers;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "confirmedUsers")
    private List<User> confirmedUsers;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private JobS jobStatus = JobS.ACTIVE;

    public Job(long id, String jobName, String jobDescription, String companyName, List<Tag> reqTags, JobS jobStatus) {
        this.id = id;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.companyName = companyName;
        this.reqTags = reqTags;
        this.jobStatus = jobStatus;
    }
}
