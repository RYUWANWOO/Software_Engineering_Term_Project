package com.example.softwareengineering.api;

import com.example.softwareengineering.Service.LectureListApiService;
import com.example.softwareengineering.Service.UserApiService;
import com.example.softwareengineering.model.network.Header;
import com.example.softwareengineering.model.network.request.UserApiRequest;
import com.example.softwareengineering.model.network.response.UserApiResponse;
import com.example.softwareengineering.model.network.response.UserLectureList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserApiService userApiService;
    private final LectureListApiService lectureListApiService;

    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody UserApiRequest request) {
        return userApiService.create(request);
    }

    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        return userApiService.read(id);
    }

    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(@RequestBody UserApiRequest request) {
        return userApiService.update(request);
    }
    @DeleteMapping("{id}")  // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return userApiService.delete(id);
    }
}
