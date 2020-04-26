DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person (

    person_id SERIAL,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    patronymic varchar(100) not null,
    date_birth date not null
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport(

    passport_id SERIAL not null,
    person_id integer not null,
    serial varchar(10) not null,
    number varchar(10) not null,
    date_issue date not null,
    issue_department varchar(200),
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT

);

