package ru.malkov.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.malkov.testtask.enums.Gender;
import ru.malkov.testtask.entities.Employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * A DTO for the {@link ru.malkov.testtask.entities.Employee} entity
 */
@Data
@AllArgsConstructor
public class EmployeeDto implements Serializable {
    private final Long id;
    private final String name;
    private final Gender gender;
    private final String dateOfBirth;
    private final String socialSecurityNumber;

    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.gender = employee.getGender();
        this.dateOfBirth = employee.getDateOfBirth().toString();
        this.socialSecurityNumber = employee.getSocialSecurityNumber();
    }

    public Employee generateEmployee() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateOfBirth, dateFormat);
        return new Employee(this.id, this.name, this.gender, date, this.socialSecurityNumber);
    }
}