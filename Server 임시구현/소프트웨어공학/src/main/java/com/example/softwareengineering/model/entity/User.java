package com.example.softwareengineering.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "lectureLists")
@Builder
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * status = 0: Admin, 1:Faculty, 2:Student
     */
    private int status;

    private String name;

    private int age;

    private String major;

    private String password;

    private String email;

    // Lecture 1:N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<LectureList> lectureLists;

}
