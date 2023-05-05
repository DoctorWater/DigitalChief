package ru.malkov.testtask.dto;

public record ExceptionDto(Throwable exception, String message) {
}
