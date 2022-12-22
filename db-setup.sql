-- Use this script to setup your Planetarium database

create table users(
	id serial primary key,
	username varchar(20) unique, --usernames must be unique because of the unique constraint we added
	password varchar(20)
);

create table planets(
	id serial primary key,
	name varchar(20),
	ownerId int references users(id) on delete cascade -- or on delete set null
	-- anytime you see "references" you are looking at a "foreign key". All foreign keys
	-- must point to a primary key on another table
);

create table moons(
	id serial primary key,
	name varchar(20),
	myPlanetId int references planets(id) on delete cascade -- or "on delete set null"
);