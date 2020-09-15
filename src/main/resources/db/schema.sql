--
-- Sample dataset containing a number of Hotels in various Cities across the world.  The reviews are entirely fictional :)
--

create table city
(
    id      bigint       not null,
    country varchar(255) not null,
    map     varchar(255) not null,
    name    varchar(255) not null,
    state   varchar(255) not null,
    primary key (id)
);

create table hotel
(
    id      bigint       not null,
    address varchar(255) not null,
    name    varchar(255) not null,
    zip     varchar(255) not null,
    city_id bigint       not null,
    primary key (id)
);


create table review
(
    id            bigint        not null,
    check_in_date date          not null,
    details       varchar(5000) not null,
    idx           integer       not null,
    rating        integer       not null,
    title         varchar(255)  not null,
    trip_type     integer       not null,
    hotel_id      bigint        not null,
    primary key (id)
);


alter table hotel add constraint UK_i80qjsl99gene06k3t31y3sv5 unique (city_id, name);
alter table hotel add constraint FKf1iabdv6bi2yohh9h48wce42x foreign key (city_id) references city;
alter table review add constraint FKi0ly7ivbh8ijdgoi7cwtuoavt foreign key (hotel_id) references hotel;

CREATE SEQUENCE CITY_SEQ MINVALUE 1 MAXVALUE 10000000 INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE HOTEL_SEQ MINVALUE 1 MAXVALUE 10000000 INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE REVIEW_SEQ MINVALUE 1 MAXVALUE 10000000 INCREMENT BY 1 START WITH 1;
