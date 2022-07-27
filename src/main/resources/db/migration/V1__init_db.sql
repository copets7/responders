create table responders.battery
(
    id     bigint auto_increment
        primary key,
    amount bigint null
);

create table responders.choke
(
    id     bigint auto_increment
        primary key,
    amount bigint null
);

create table responders.responders
(
    id                         bigint auto_increment
        primary key,
    additional_information     varchar(255) null,
    date_of_receipt_for_repair datetime(6)  null,
    hr_tag                     varchar(255) null,
    refurbished                bit          not null,
    repair_end_date            datetime(6)  null
);

create table responders.supercapacitor
(
    id     bigint auto_increment
        primary key,
    amount bigint null
);

create table responders.users
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) null,
    name     varchar(255) null,
    password varchar(255) null,
    role     varchar(255) null
);