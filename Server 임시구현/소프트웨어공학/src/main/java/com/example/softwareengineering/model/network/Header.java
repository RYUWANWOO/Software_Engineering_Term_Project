package com.example.softwareengineering.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    //api 통신시간
    private LocalDateTime transactionTime;

    //api 통신 설명
    private String description;

    private T value;

    //api 결과
    private boolean result;


    // OK
    public static <T> Header<T> OK() {
        return (Header<T>) Header.builder()
                .result(true)
                .transactionTime(LocalDateTime.now())
                .build();
    }

    // DATA OK
    public static <T> Header<T> OK(T data) {
        return (Header<T>)Header.builder()
                .result(true)
                .transactionTime(LocalDateTime.now())
                .value(data)
                .build();
    }

    // ERROR
    public static <T> Header<T> ERROR(String description) {
        return (Header<T>)Header.builder()
                .result(false)
                .transactionTime(LocalDateTime.now())
                .description(description)
                .build();
    }

}
