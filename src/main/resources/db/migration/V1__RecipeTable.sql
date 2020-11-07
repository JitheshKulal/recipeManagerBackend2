CREATE TABLE RM_RECIPE_DATA (
	id VARCHAR(200) NOT NULL PRIMARY KEY,
	shadeNo VARCHAR(100),
	colors VARCHAR(4000),
	chemicals VARCHAR(4000),
	submitTime DATE
);

CREATE TABLE RM_CHEMICAL_DATA(
	id varchar(200),
	chemicalname varchar(100),
	description varchar(4000),
	submittime DATE
);
CREATE TABLE RM_COLOR_DATA(
	id varchar(200),
	colorname varchar(100),
	description varchar(4000),
	submittime DATE
);

CREATE TABLE RM_USERS(
	user_id varchar(100),
	username varchar(100),
	password varchar(500),
	email varchar(100),
	active boolean,
	created_on DATE
);

CREATE table rm_tokens(
    refreshId varchar(1000),
    token varchar(1000),
    createdOn DATE
);