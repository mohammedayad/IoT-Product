--liquibase formatted sql
--changeset ayad:1

create table if not exists sim_card
(
    simId                       uuid         not null
        constraint sim_card_pkey
            primary key,
    operatorCode             varchar(255) not null,
    country                 varchar(255) not null,
    status                 varchar(255) not null
);

create table if not exists iot_device
(
    deviceId                 uuid         not null
        constraint iot_device_pkey
            primary key,
    deviceName     varchar(255) not null,
    description     varchar(255) ,
    temperature      numeric not null,
    configStatus       varchar(255) not null,
    simId uuid
        constraint fk_sim_card
            references sim_card
);