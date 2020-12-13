CREATE TABLE RM_RECIPE_DATA (
	id SERIAL NOT NULL PRIMARY KEY,
	shadeNo VARCHAR(100),
	colors VARCHAR(4000),
	chemicals VARCHAR(4000),
	submitTime DATE
);

CREATE TABLE RM_CHEMICAL_DATA(
	id SERIAL,
	chemicalname varchar(100),
	description varchar(4000),
	submittime DATE
);
CREATE TABLE RM_COLOR_DATA(
	id SERIAL,
	colorname varchar(100),
	description varchar(4000),
	submittime DATE
);

CREATE TABLE RM_USERS(
	user_id SERIAL,
	username varchar(100),
	password varchar(500),
	email varchar(100),
	active boolean,
	created_on DATE
);

CREATE table rm_tokens(
    refreshId SERIAL,
    token varchar(1000),
    createdOn DATE
);