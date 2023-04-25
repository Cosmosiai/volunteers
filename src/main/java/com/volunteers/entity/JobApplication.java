package com.volunteers.entity;

import com.volunteers.enums.JobApplicationS;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "jobApplication")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private User username;

    @Column(name = "jobApplicationS")
    @Enumerated(EnumType.STRING)
    private JobApplicationS status;
}
