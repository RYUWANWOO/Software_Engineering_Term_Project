package com.example.softwareengineering.model.entity;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "lectureList")
@Builder
@Accessors(chain = true)
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lecture;

    private LocalDateTime registerTime;

    private String deadline;

    @ManyToOne
    private LectureList lectureList;
}