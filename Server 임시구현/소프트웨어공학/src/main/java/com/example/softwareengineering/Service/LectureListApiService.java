package com.example.softwareengineering.Service;

import com.example.softwareengineering.model.entity.LectureList;
import com.example.softwareengineering.model.entity.User;
import com.example.softwareengineering.model.network.Header;
import com.example.softwareengineering.model.network.request.LectureListApiRequest;
import com.example.softwareengineering.model.network.response.LectureListApiResponse;
import com.example.softwareengineering.model.network.response.UserApiResponse;
import com.example.softwareengineering.model.network.response.UserLectureList;
import com.example.softwareengineering.repository.LectureListRepository;
import com.example.softwareengineering.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureListApiService {

    private final LectureListRepository lectureListRepository;

    private final UserRepository userRepository;

    public Header<LectureListApiResponse> create(LectureListApiRequest request) {
        LectureListApiRequest lectureListApiRequest = request;
        LectureList lectureList = LectureList.builder()
                .lectureName(lectureListApiRequest.getLectureName())
                .user(userRepository.findById(lectureListApiRequest.getUserId()).get())
                .build();
        LectureList newLectureList = lectureListRepository.save(lectureList);
        return Header.OK(res(newLectureList));
    }


    public Header<UserLectureList> read(Long id) {
        Optional<User> u = userRepository.findById(id);
        User user = u.get();
        UserApiResponse userApiResponse = UserResponse(user);


        List<LectureList> lectureListList = user.getLectureLists();

        List<LectureListApiResponse> lectureListApiResponses = lectureListList.stream()
                .map(lecture -> {
                    return response(lecture);
                })
                .map(response -> (response).getValue())
                .collect(Collectors.toList());
        userApiResponse.setLectureListList(lectureListApiResponses);

        UserLectureList userLectureList = UserLectureList.builder()
                .userApiResponse(userApiResponse)
                .build();
        return Header.OK(userLectureList);
    }

    public Header<LectureListApiResponse> response(LectureList lectureList) {
        LectureListApiResponse body = LectureListApiResponse.builder()
                .id(lectureList.getId())
                .lectureName(lectureList.getLectureName())
                .userId(lectureList.getUser().getId())
                .build();

        return Header.OK(body);
    }

    public LectureListApiResponse res(LectureList lectureList) {
        LectureListApiResponse body = LectureListApiResponse.builder()
                .userId(lectureList.getUser().getId())
                .lectureName(lectureList.getLectureName())
                .build();

        return body;
    }

    public UserApiResponse UserResponse(User user) {
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .age(user.getAge())
                .major(user.getMajor())
                .name(user.getName())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();

        return userApiResponse;
    }
}
