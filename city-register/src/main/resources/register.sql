DROP TABLE IF EXISTS cr_adress_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_adress;
DROP TABLE IF EXISTS cr_street;
DROP TABLE IF EXISTS cr_district;

CREATE TABLE cr_district (
    district_code integer not null,
    district_name varchar(300),
    PRIMARY KEY(district_code)
);
INSERT INTO cr_district (district_code, district_name) VALUES (1, 'Центральный');

CREATE TABLE cr_street (
    street_code integer not null,
    street_name varchar(300),
    PRIMARY KEY (street_code)
);
INSERT INTO cr_street (street_code, street_name) VALUES (1, 'Кирова');


CREATE TABLE cr_adress (
    adress_id SERIAL,
    district_code integer not null,
    street_code integer not null,
    building varchar(10) not null,
    extension varchar(10),
    apartment varchar(10),
    PRIMARY KEY (adress_id),
    FOREIGN KEY (district_code) REFERENCES cr_district(district_code) ON DELETE RESTRICT,
    FOREIGN KEY (street_code) REFERENCES cr_street(street_code) ON DELETE RESTRICT
);
INSERT INTO cr_adress (district_code, street_code, building, extension, apartment)
    VALUES (1, 1, '10', '2', '141');

CREATE TABLE cr_person (
	person_id SERIAL,
    sur_name varchar(100) not null,
    given_name varchar(100) not null,
    patronymic varchar(100) not null,
    date_of_birth date not null,
    passport_seria varchar(10),
    passport_number varchar(10),
    passport_date date,
    certificate_number varchar(10) null,
    certificate_date date null,
    PRIMARY KEY (person_id)
);
INSERT INTO cr_person (sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date, certificate_number,certificate_date)
    VALUES ('Васильев', 'Павел', 'Николаевич', '1995-03-18', '1234', '123456', '2015-04-11', null, null);
INSERT INTO cr_person (sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date, certificate_number,certificate_date)
    VALUES ('Васильева', 'Ирина', 'Петровна', '1997-04-05', '4321', '654321', '2017-04-05', null, null);
INSERT INTO cr_person (sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date, certificate_number,certificate_date)
    VALUES ('Васильев', 'Александр', 'Павлович', '2015-01-11', null, null, null, '456123', '2015-01-21');
INSERT INTO cr_person (sur_name, given_name, patronymic, date_of_birth, passport_seria, passport_number, passport_date, certificate_number,certificate_date)
    VALUES ('Васильева', 'Ирина', 'Петровна', '2018-10-11', null, null, null, '987654', '2018-11-21');

CREATE TABLE cr_adress_person (
    person_adress_id SERIAL,
    adress_id integer not null,
    person_id integer not null,
    start_date date not null,
    end_date date,
    temporal boolean DEFAULT false,
    PRIMARY KEY (person_adress_id),
    FOREIGN KEY (adress_id) REFERENCES cr_adress(adress_id) ON DELETE RESTRICT,
    FOREIGN KEY (person_id) REFERENCES cr_person(person_id) ON DELETE RESTRICT
);

INSERT INTO cr_adress_person (adress_id, person_id, start_date, end_date, temporal)
VALUES (1, 1, '2014-10-12', null, false);
INSERT INTO cr_adress_person (adress_id, person_id, start_date, end_date, temporal)
VALUES (1, 2, '2014-10-12', null, false);
INSERT INTO cr_adress_person (adress_id, person_id, start_date, end_date)
VALUES (1, 3, '2016-02-05', null);
INSERT INTO cr_adress_person (adress_id, person_id, start_date, end_date)
VALUES (1, 4, '2018-12-11', null);