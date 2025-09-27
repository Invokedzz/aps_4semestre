package org.smartbar.aps_4semestre.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionDTO (

        String message,

        HttpStatus status,

        LocalDateTime timestamp

) {}
