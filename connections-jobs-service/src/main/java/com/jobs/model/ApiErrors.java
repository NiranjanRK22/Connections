package com.jobs.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter

@AllArgsConstructor
@ToString
public class ApiErrors {
    LocalDateTime timestamp;
    HttpStatus status;
    String message;
    String Path;

    public ApiErrors() {
    }
}
