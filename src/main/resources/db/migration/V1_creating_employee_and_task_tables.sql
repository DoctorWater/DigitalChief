create table employee
(
    employee_id            bigint auto_increment
        primary key,
    name                   varchar(100) not null,
    gender                 varchar(100) null,
    date_of_birth          date         not null,
    social_security_number varchar(100) null
);

create table task
(
    task_id     bigint auto_increment
        primary key,
    name        varchar(100) not null,
    description varchar(400) null,
    deadline    date         null,
    type        varchar(100) not null,
    employee_id bigint       null,
    constraint task_employee_employee_id_fk
        foreign key (employee_id) references employee (employee_id)
);