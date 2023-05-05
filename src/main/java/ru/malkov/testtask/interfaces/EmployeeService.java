package ru.malkov.testtask.interfaces;

import jakarta.persistence.EntityNotFoundException;
import ru.malkov.testtask.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getById(Long id) throws EntityNotFoundException;

    List<Employee> getByName(String name);

    void saveOrUpdate(Employee entity);

    void saveOrUpdate(List<Employee> entities);

    void deleteById(Long id);

    void deleteById(List<Long> ids);
}
