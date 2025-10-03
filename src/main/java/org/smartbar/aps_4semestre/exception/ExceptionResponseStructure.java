package org.smartbar.aps_4semestre.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collection;

public class ExceptionResponseStructure {

    public static ExceptionDTO response (Collection <String> messages, HttpStatus httpStatus) {

        LocalDateTime timeExceptionWasThrown = LocalDateTime.now();

        return new ExceptionDTO(messages, httpStatus, timeExceptionWasThrown);

    }

}
