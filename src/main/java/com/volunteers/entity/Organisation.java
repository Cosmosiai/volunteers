package com.volunteers.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "ORGANISATIONS")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "CEOFirstName")
    private String firstName;

    @Column(name = "CEOLastName")
    private String lastName;

    @Column(name = "companyEmail")
    private String email;

}