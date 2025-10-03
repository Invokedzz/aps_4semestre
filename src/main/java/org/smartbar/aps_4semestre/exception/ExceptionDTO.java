package org.smartbar.aps_4semestre.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collection;

public record ExceptionDTO (

        Collection <String> messages,

        HttpStatus status,

        @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
        LocalDateTime timestamp

) {}
