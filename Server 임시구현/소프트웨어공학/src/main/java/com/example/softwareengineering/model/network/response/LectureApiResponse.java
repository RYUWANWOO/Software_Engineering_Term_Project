package com.example.softwareengineering.model.network.response;

import com.example.softwareengineering.model.entity.LectureList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureApiResponse {
    private Long id;

    private String lecture;

    private LocalDateTime registerTime;

    private String deadline;

    private Long lectureListId;
}
