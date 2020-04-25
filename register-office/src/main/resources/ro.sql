DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person (
    person_id SERIAL,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    PRIMARY KEY (person_id)
);