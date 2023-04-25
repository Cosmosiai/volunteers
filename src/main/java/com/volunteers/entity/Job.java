package com.volunteers.entity;

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

    @Column(name = "companyName")
    private String companyName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserTags")
    private List<Tag> reqTags;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Users")
    private List<User> appliedUsers;


}
