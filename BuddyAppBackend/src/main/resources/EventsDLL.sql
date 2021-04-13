DROP TABLE IF EXISTS heybuddy.events;
CREATE TABLE heybuddy.events
(event_id bigint default nextval('heybuddy.seqIID') PRIMARY KEY,
discription VARCHAR ( 50 ),
time bigint,
event_type smallint,
event_location VARCHAR ( 50 ),
is_transportation_available boolean,
charges NUMERIC ( 999, 2 ),
participation_type smallint,
is_meal_provided boolean,
is_closed boolean default false,
username VARCHAR ( 50 ) REFERENCES heybuddy.users (username));


