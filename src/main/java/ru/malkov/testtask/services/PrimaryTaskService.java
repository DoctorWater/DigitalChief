package ru.malkov.testtask.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.malkov.testtask.entities.Task;
import ru.malkov.testtask.repositories.TaskRepository;

import java.util.List;

@Service
public class PrimaryTaskService implements ru.malkov.testtask.interfaces.TaskService {
    TaskRepository repository;

    public PrimaryTaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task getById(Long id) throws EntityNotFoundException {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Task> getByEmployeeId(Long employeeId) {
        return repository.getTasksByEmployee_Id(employeeId);
    }

    @Override
    public void saveOrUpdate(Task entity) {
        repository.save(entity);
    }

    @Override
    public void saveOrUpdate(List<Task> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteById(List<Long> ids) {
        repository.deleteAllById(ids);
    }
}
