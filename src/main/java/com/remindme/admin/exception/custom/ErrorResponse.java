package com.remindme.admin.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String details;
    private Instant timestamp;
}
