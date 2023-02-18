create table person
(
    id   bigint not null
        constraint pk_person
            primary key,
    name varchar(255),
    age  integer
);
