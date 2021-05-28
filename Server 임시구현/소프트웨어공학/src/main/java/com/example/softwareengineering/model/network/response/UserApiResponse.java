package com.example.softwareengineering.model.network.response;

import com.example.softwareengineering.model.entity.LectureList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {
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

    private List<LectureListApiResponse> lectureListList;
}
