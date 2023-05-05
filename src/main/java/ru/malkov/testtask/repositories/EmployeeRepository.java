package ru.malkov.testtask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malkov.testtask.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getEmployeesByName(String name);
}
