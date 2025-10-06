package org.smartbar.aps_4semestre.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <ExceptionDTO> handleArgumentNotValidException (MethodArgumentNotValidException e) {

        List <String> messages = getListOfErrorMessagesRelatedToArgumentNotValidEx(e);

        ExceptionDTO response = generateResponse(messages, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity <ExceptionDTO> handleBadRequestException (Exception e) {

        String message = e.getMessage();

        ExceptionDTO response = generateResponse(List.of(message), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    private List <String> getListOfErrorMessagesRelatedToArgumentNotValidEx (MethodArgumentNotValidException ex) {

        return ex.getBindingResult().getAllErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

    }

    private ExceptionDTO generateResponse (Collection <String> message, HttpStatus status) {

        return ExceptionResponseStructure.response(message, status);

    }

}
