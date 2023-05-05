package ru.malkov.testtask.interfaces;

import jakarta.persistence.EntityNotFoundException;
import ru.malkov.testtask.entities.Task;

import java.util.List;

public interface TaskService {
    Task getById(Long id) throws EntityNotFoundException;

    List<Task> getByEmployeeId(Long employeeId);

    void saveOrUpdate(Task entity);

    void saveOrUpdate(List<Task> entities);

    void deleteById(Long id);

    void deleteById(List<Long> ids);
}
