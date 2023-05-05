package ru.malkov.testtask.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.malkov.testtask.entities.Employee;
import ru.malkov.testtask.interfaces.EmployeeService;
import ru.malkov.testtask.repositories.EmployeeRepository;

import java.util.List;

@Service
public class PrimaryEmployeeService implements EmployeeService {
    EmployeeRepository repository;

    public PrimaryEmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee getById(Long id) throws EntityNotFoundException {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Employee> getByName(String name) {
        return repository.getEmployeesByName(name);
    }

    @Override
    public void saveOrUpdate(Employee entity) {
        repository.save(entity);
    }

    @Override
    public void saveOrUpdate(List<Employee> entities) {
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
