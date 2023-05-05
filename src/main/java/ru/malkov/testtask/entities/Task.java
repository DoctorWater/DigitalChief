package ru.malkov.testtask.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.malkov.testtask.enums.TaskType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate deadline;
    @Enumerated(EnumType.STRING)
    private TaskType type;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Task(Long id, String name, String description, String deadline, TaskType type, Employee employee) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(deadline, dateFormat);
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = date;
        this.type = type;
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;

        if (getId() != null ? !getId().equals(task.getId()) : task.getId() != null) return false;
        if (getName() != null ? !getName().equals(task.getName()) : task.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(task.getDescription()) : task.getDescription() != null)
            return false;
        if (getDeadline() != null ? !getDeadline().equals(task.getDeadline()) : task.getDeadline() != null)
            return false;
        if (getType() != task.getType()) return false;
        return getEmployee() != null ? getEmployee().equals(task.getEmployee()) : task.getEmployee() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getDeadline() != null ? getDeadline().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getEmployee() != null ? getEmployee().hashCode() : 0);
        return result;
    }

    /*create table task
(
    task_id     bigint auto_increment
        primary key,
    name        varchar(100) not null,
    description varchar(400) null,
    deadline    date         null,
    type        varchar(100) null,
    employee    bigint       null,
    constraint task_employee_employee_id_fk
        foreign key (employee) references employee (employee_id)
);*/
}
