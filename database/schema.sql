-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
-- DROP TABLE IF EXISTS app_user;

CREATE TABLE user (
	user_name varchar(100) PRIMARY KEY,
	password varchar(25),
	family_id int NOT NULL, 
	is_owner boolean,
	salt varchar(255) NOT NULL,
	
	constraint fk_user_family_family_id foreign key (family_id) references family (family_id)
); 

CREATE TABLE family (
  	family_id SERIAL PRIMARY KEY,
 	family_name varchar(32) NOT NULL
  
);

CREATE TABLE people (
	people_id SERIAL PRIMARY KEY,
	family_id int,
	name varchar(100),
	is_parent boolean,
	inactive boolean DEFAULT false,
	
	constraint fk_people_family_family_id foreign key (family_id) references family (family_id)
);

CREATE TABLE book_type (
	book_type_id SERIAL PRIMARY KEY,
	book_type varchar(50) NOT NULL
);

CREATE TABLE book (
	book_id SERIAL PRIMARY KEY,
	title varchar(255) NOT NULL,
	author_first varchar(100),
	author_last varchar(100) NOT NULL,
	illustrator_first varchar(100),
	illustrator_last varchar(100),
	book_type int,
	isbn int,
	image varchar(600),
	
	constraint fk_book_book_type_book_type foreign key (book_type) references book_type (book_type_id)
);



CREATE TABLE people_book (
	people_book_id SERIAL PRIMARY KEY,
	book_id int NOT NULL,
	people_id int NOT NULL,
	
	constraint fk_people_book_book_id foreign key (book_id) references book (book_id),
	constraint fk_people_book_people_id foreign key (people_id) references people (people_id)
);

CREATE TABLE reading_type (
	reading_type_id SERIAL PRIMARY KEY,
	reading_type varchar(100) NOT NULL
);

CREATE TABLE session (
	session_id SERIAL PRIMARY KEY,
	people_book_id int NOT NULL,
	date_of_reading date NOT NULL,
	minutes_read int NOT NULL,
	type_of_reading int,
	
	constraint fk_session_people_book_id foreign key (people_book_id) references people_book (people_book_id),
	constraint fk_session_reading_type_type_of_reading foreign key (type_of_reading) references reading_type (reading_type_id)
);



CREATE TABLE goal (
	goal_id SERIAL PRIMARY KEY,
	name_of_goal varchar(150),
	start_date date NOT NULL,
	number_of_days int NOT NULL,
	description varchar(500),
	minutes_to_reach_goal int NOT NULL,
	is_complete boolean
);

CREATE TABLE goal_people (
	goal_id int NOT NULL,
	people_id int NOT NULL,
	
	constraint fk_goal_people_goal_id foreign key (goal_id) references goal (goal_id),
	constraint fk_goal_people_people_id foreign key (people_id) references people (people_id)
);

CREATE TABLE competition (
	competition_id SERIAL PRIMARY KEY,
	name_of_competition varchar(150),
	start_date date NOT NULL,
	end_date date NOT NULL,
	description varchar,
	minutes_to_finish int NOT NULL
);

CREATE TABLE competition_people (
	competition_id int NOT NULL,
	people_id int NOT NULL,
	
	constraint fk_competition_people_competition_id foreign key (competition_id) references competition (competition_id),
	constraint fk_competition_people_people_id foreign key (people_id) references people (people_id)
);

COMMIT;