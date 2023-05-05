package ru.malkov.testtask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malkov.testtask.entities.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTasksByEmployee_Id(Long id);
}
