package com.example.softwareengineering.model.network.request;

import com.example.softwareengineering.model.entity.LectureList;
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
public class UserApiRequest {
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

}
