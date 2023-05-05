package ru.malkov.testtask.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.malkov.testtask.dto.ExceptionDto;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handleException(IllegalArgumentException e) {
        return new ExceptionDto(e, e.getMessage());
    }

}
