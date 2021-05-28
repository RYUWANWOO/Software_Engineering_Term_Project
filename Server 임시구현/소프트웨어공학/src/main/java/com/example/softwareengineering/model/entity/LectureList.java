package com.example.softwareengineering.model.entity;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "lecture")
@Builder
@Accessors(chain = true)
public class LectureList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lectureName;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lectureList")
    private List<Lecture> lecture;

}