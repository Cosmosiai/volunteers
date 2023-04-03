package com.volunteers.entity;

import jakarta.persistence.*;
import lombok.*;
import com.volunteers.enums.Statuses;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "reputation")
    private int reputation;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Statuses status;
}