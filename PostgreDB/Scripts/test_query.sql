
/*
DROP TABLE users;
*/

CREATE TABLE users (
	user_id int NOT NULL unique,
	last_name varchar(24) NOT NULL,
	first_name varchar(24) NOT NULL,
	email varchar(128) NOT NULL,
	password varchar (24) NOT NULL,
	/*date_added default NULL,*/
	PRIMARY KEY (email)
);

