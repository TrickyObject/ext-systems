DROP TABLE IF EXISTS sr_student_document;
DROP TABLE IF EXISTS sr_faculty;
DROP TABLE IF EXISTS sr_university;
DROP TABLE IF EXISTS sr_student;

CREATE TABLE sr_student
(
    student_id SERIAL,
    date_of_birth date not null,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	middle_name varchar(100) not null,
	passport_date date not null,
	passport_number varchar(10) not null,
	passport_serial varchar(10) not null,
    PRIMARY KEY (student_id)
);

CREATE TABLE sr_university
(
    university_id SERIAL,
    university_name varchar(300) not null,
    PRIMARY KEY (university_id)
);

CREATE TABLE sr_faculty
(
    faculty_id SERIAL,
    faculty_name varchar(300),
	university_id integer,
    PRIMARY KEY (faculty_id),
	FOREIGN KEY (university_id) REFERENCES sr_university(university_id) ON DELETE RESTRICT
);

CREATE TABLE sr_student_document
(
    document_id SERIAL,
    document_date date not null,
	document_number varchar(100) not null,
	expired_date date not null,
	student_form integer not null,
	faculty_id integer not null,
    student_id integer not null,
    PRIMARY KEY (document_id),
	FOREIGN KEY (faculty_id) REFERENCES sr_faculty(faculty_id) ON DELETE RESTRICT,
	FOREIGN KEY (student_id) REFERENCES sr_student(student_id) ON DELETE RESTRICT

);
