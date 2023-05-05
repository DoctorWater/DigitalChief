package ru.malkov.testtask.controllers;

import org.springframework.web.bind.annotation.*;
import ru.malkov.testtask.dto.TaskDto;
import ru.malkov.testtask.entities.Task;
import ru.malkov.testtask.interfaces.EmployeeService;
import ru.malkov.testtask.interfaces.TaskService;
import ru.malkov.testtask.services.PrimaryTaskService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "task")
public class TaskController {
    private final TaskService service;
    private final EmployeeService secondaryService;

    public TaskController(PrimaryTaskService service, EmployeeService secondaryService) {
        this.service = service;
        this.secondaryService = secondaryService;
    }

    @GetMapping(value = "/get/by-id")
    public TaskDto getById(@RequestParam Long id) {
        Task result = service.getById(id);
        return new TaskDto(result.getId(), result.getName(), result.getDescription(), result.getDeadline().toString(), result.getType(), result.getEmployee().getId());
    }

    @GetMapping(value = "/get/by-employee")
    public List<TaskDto> getByEmployee(@RequestParam Long employeeId) {
        ArrayList<TaskDto> result = new ArrayList<>();
        for (Task task : service.getByEmployeeId(employeeId)) {
            result.add(new TaskDto(task.getId(), task.getName(), task.getDescription(), task.getDeadline().toString(), task.getType(), task.getEmployee().getId()));
        }
        return result;
    }

    @PostMapping(value = "/save/one")
    public String saveOrUpdate(@RequestBody TaskDto taskDto) {
        Task newTask = new Task(taskDto.id(), taskDto.name(), taskDto.description(), taskDto.deadline(), taskDto.type(), secondaryService.getById(taskDto.employeeId()));
        service.saveOrUpdate(newTask);
        return "Successful";
    }

    @PostMapping(value = "/save/list")
    public String saveOrUpdate(@RequestBody List<TaskDto> tasks) {
        List<Task> result = new ArrayList<>();
        for (TaskDto taskDto : tasks) {
            Task newTask = new Task(taskDto.id(), taskDto.name(), taskDto.description(), taskDto.deadline(), taskDto.type(), secondaryService.getById(taskDto.employeeId()));
            result.add(newTask);
        }
        service.saveOrUpdate(result);
        return "Successful";
    }

    @DeleteMapping(value = "/delete/one")
    public String delete(@RequestParam Long id) {
        service.deleteById(id);
        return "Successfully deleted";
    }

    @DeleteMapping(value = "/delete/list")
    public String delete(@RequestBody List<Long> ids) {
        service.deleteById(ids);
        return "Successfully deleted";
    }

    //TODO: 2:17:11
}
