package ru.malkov.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.malkov.testtask.entities.Task;
import ru.malkov.testtask.enums.TaskType;

import java.io.Serializable;

/**
 * A DTO for the {@link Task} entity
 */

public record TaskDto(Long id, String name, String description, String deadline, TaskType type,
                      Long employeeId) implements Serializable {
}