-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
-- DROP TABLE IF EXISTS app_user;

CREATE TABLE account (
  account_id SERIAL PRIMARY KEY,
  user_name varchar(32) NOT NULL UNIQUE,
  password varchar(32) NOT NULL,
  role varchar(32),
  salt varchar(255) NOT NULL
);

CREATE TABLE people (
	people_id SERIAL PRIMARY KEY,
	account_id int,
	name varchar(100),
	is_parent boolean NOT NULL,
	
	constraint fk_people_account_account_id foreign key (account_id) references account (account_id)
);

CREATE TABLE book (
	book_id SERIAL PRIMARY KEY,
	title varchar(255) NOT NULL,
	author_first varchar(100),
	author_last varchar(100) NOT NULL,
	illustrator_first varchar(100),
	illustrator_last varchar(100),
	book_type varchar(50),
	book_type_other varchar(50),
	isbn int(13),
	
	constraint chk_book_type check (book_type IN ('Paper', 'AudioBook', 'Digital', 'Other')),
	constraint chk_book_type_other check ((book_type = 'Other' AND book_type_other is not null) OR (book_type <> 'Other' AND book_type_other is null))
);

CREATE TABLE people_book (
	id SERIAL PRIMARY KEY,
	book_id int NOT NULL,
	people_id NOT NULL,
	
	constraint fk_people_book_book_id foreign key (book_id) references book (book_id),
	constraint fk_people_book_people_id foreign key (people_id) references people (people_id),
);

CREATE TABLE session (
	id int NOT NULL,
	date_of_reading date NOT NULL,
	minutes_read int NOT NULL,
	type_of_reading varchar(50),
	type_of_reading_other varchar(50),
	
	constraint fk_session_people_book_id foreign key (id) references people_book (id),
	constraint chk_type_of_reading check (type_of_reading IN ('Read-Aloud (reader)', 'Read-Aloud (listener)', 'Read To Self', 'Listened To', 'Other')),
	constraint chk_type_of_reading_other check ((type_of_reading = 'Other' AND type_of_reading_other is not null) OR (type_of_reading <> 'Other' AND type_of_reading_other is null))
);

CREATE TABLE goal (
	goal_id SERIAL PRIMARY KEY,
	name_of_goal varchar(150),
	start_date date NOT NULL;
	number_of_days int NOT NULL,
	description varchar(500),
	minutes_to_reach_goal int NOT NULL
);

CREATE TABLE goal_people (
	goal_id int NOT NULL,
	people_id int NOT NULL;
	
	constraint fk_goal_people_goal_id foreign key (goal_id) references goal (goal_id),
	constraint fk_goal_people_people_id foreign key (people_id) references people_book (people_id)
);

CREATE TABLE competition (
	competition_id PRIMARY KEY,
	name_of_competition varchar(150),
	start_date date NOT NULL,
	end_date date NOT NULL,
	description varchar,
	minutes_to_finish int NOT NULL
);

CREATE TABLE competition_people (
	competition_id int NOT NULL,
	people_id int NOT NULL;
	
	constraint fk_competition_people_competition_id foreign key (competition_id) references competition (competition_id),
	constraint fk_competition_people_people_id foreign key (people_id) references people_book (people_id)
);

ROLLBACK;