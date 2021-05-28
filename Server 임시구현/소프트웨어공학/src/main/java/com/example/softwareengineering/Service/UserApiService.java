package com.example.softwareengineering.Service;

import com.example.softwareengineering.model.entity.User;
import com.example.softwareengineering.model.network.Header;
import com.example.softwareengineering.model.network.request.UserApiRequest;
import com.example.softwareengineering.model.network.response.UserApiResponse;
import com.example.softwareengineering.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserApiService {

    @Autowired
    private UserRepository userRepository;

    public Header<UserApiResponse> create(UserApiRequest request) {
        UserApiRequest body = request;

        User user = User.builder()
                .age(body.getAge())
                .email(body.getEmail())
                .major(body.getMajor())
                .name(body.getName())
                .password(body.getPassword())
                .status(body.getStatus())
                .build();
        User newUser = userRepository.save(user);

        return Header.OK(response(newUser));
    }

    public Header<UserApiResponse> update(UserApiRequest request) {
        Optional<User> optional = userRepository.findById(request.getId());

        return optional.map(user -> {
            user.setAge(request.getAge())
                    .setEmail(request.getEmail())
                    .setMajor(request.getMajor())
                    .setName(request.getName())
                    .setPassword(request.getPassword())
                    .setStatus(request.getStatus())
            ;
            return user;
        })
                .map(user -> userRepository.save(user))
                .map(user ->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    public Header<UserApiResponse> read(Long id) {
        return userRepository.findById(id)
                .map(user ->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터없음"));
    }


    public Header delete(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return optional.map(user -> {
            userRepository.delete(user);
            return Header.OK();
        })
                .orElseGet(()->Header.ERROR("데이터없음"));
    }


    private UserApiResponse response(User user) {

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .age(user.getAge())
                .email(user.getEmail())
                .major(user.getMajor())
                .name(user.getName())
                .password(user.getPassword())
                .status(user.getStatus())
                .build();

        return userApiResponse;
    }

}
