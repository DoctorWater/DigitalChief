package ru.malkov.testtask.controllers;

import org.springframework.web.bind.annotation.*;
import ru.malkov.testtask.dto.EmployeeDto;
import ru.malkov.testtask.entities.Employee;
import ru.malkov.testtask.interfaces.EmployeeService;
import ru.malkov.testtask.services.PrimaryEmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(PrimaryEmployeeService service) {
        this.service = service;
    }

    @GetMapping(value = "/get/by-id")
    public EmployeeDto getById(@RequestParam Long id) {
        Employee result = service.getById(id);
        return new EmployeeDto(result);
    }

    @GetMapping(value = "/get/by-name")
    public List<EmployeeDto> getByName(@RequestParam String name) {
        ArrayList<EmployeeDto> result = new ArrayList<>();
        for (Employee employee : service.getByName(name)) {
            result.add(new EmployeeDto(employee));
        }
        return result;
    }

    @PostMapping(value = "/save/one")
    public String saveOrUpdate(@RequestBody EmployeeDto employee) {
        Employee newbie = employee.generateEmployee();
        service.saveOrUpdate(newbie);
        return "Successful";
    }

    @PostMapping(value = "/save/list")
    public String saveOrUpdate(@RequestBody List<EmployeeDto> employees) {
        List<Employee> result = new ArrayList<>();
        for (EmployeeDto employee : employees) {
            Employee newbie = employee.generateEmployee();
            result.add(newbie);
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
}
