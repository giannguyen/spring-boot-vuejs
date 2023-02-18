create table user_data
(
    id       bigserial
        primary key,
    password varchar(255),
    role     varchar(255),
    username varchar(255)
);
