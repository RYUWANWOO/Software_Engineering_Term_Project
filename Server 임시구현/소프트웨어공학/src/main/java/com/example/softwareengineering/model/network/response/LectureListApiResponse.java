package com.example.softwareengineering.model.network.response;

import com.example.softwareengineering.model.entity.Lecture;
import com.example.softwareengineering.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureListApiResponse {
    private Long id;

    private String lectureName;

    private Long userId;

}
