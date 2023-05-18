package com.volunteers.entity;

import jakarta.persistence.*;
import lombok.*;
import com.volunteers.enums.UserS;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "reputation")
    private int reputation;

    @Column(name = "jobsDone")
    private int jobsDone;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserS status;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserTags")
    private List<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "userInvites")
    private List<Tag> invite;

    public User(String username, String password, String firstname, String lastname, List<Tag> tags) {
        this.username = username;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastname;
        this.tags = tags;
    }
}