create table user_data
(
    id       bigint not null
        primary key,
    password varchar(255),
    username varchar(255)
);