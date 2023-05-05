package ru.malkov.testtask.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import ru.malkov.testtask.enums.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(catalog = "dctesttask", name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    private String socialSecurityNumber;

    public Employee(Long id, String name, Gender gender, LocalDate dateOfBirth, String socialSecurityNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Employee(Long id, String name, Gender gender, String dateOfBirth, String socialSecurityNumber) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateOfBirth, dateFormat);
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = date;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /*create table employee
(
    employee_id            bigint auto_increment
        primary key,
    name                   varchar(100) not null,
    gender                 varchar(100) null,
    date_of_birth          date         not null,
    social_security_number varchar(100) null
);*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (getId() != null ? !getId().equals(employee.getId()) : employee.getId() != null) return false;
        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        if (getGender() != employee.getGender()) return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(employee.getDateOfBirth()) : employee.getDateOfBirth() != null)
            return false;
        return getSocialSecurityNumber() != null ? getSocialSecurityNumber().equals(employee.getSocialSecurityNumber()) : employee.getSocialSecurityNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getSocialSecurityNumber() != null ? getSocialSecurityNumber().hashCode() : 0);
        return result;
    }
}
