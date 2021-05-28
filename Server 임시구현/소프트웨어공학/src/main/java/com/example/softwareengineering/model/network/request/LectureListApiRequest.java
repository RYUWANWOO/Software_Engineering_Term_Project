package com.example.softwareengineering.model.network.request;

import com.example.softwareengineering.model.entity.Lecture;
import com.example.softwareengineering.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureListApiRequest {
    private Long id;

    private String lectureName;

    private Long userId;

}
