package com.example.softwareengineering.api;

import com.example.softwareengineering.Service.LectureListApiService;
import com.example.softwareengineering.model.entity.LectureList;
import com.example.softwareengineering.model.network.Header;
import com.example.softwareengineering.model.network.request.LectureApiRequest;
import com.example.softwareengineering.model.network.request.LectureListApiRequest;
import com.example.softwareengineering.model.network.response.LectureListApiResponse;
import com.example.softwareengineering.model.network.response.UserLectureList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lecturelist")
public class LectureListApiController {

    private final LectureListApiService lectureListApiService;

    @PostMapping("")
    public Header<LectureListApiResponse> create(@RequestBody LectureListApiRequest request) {
        return lectureListApiService.create(request);
    }

    @GetMapping("/{id}")
    public Header<UserLectureList> read(@PathVariable(name = "id") Long id) {
        return lectureListApiService.read(id);
    }


}
