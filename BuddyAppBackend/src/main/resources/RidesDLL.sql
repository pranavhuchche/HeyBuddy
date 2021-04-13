DROP TABLE IF EXISTS heybuddy.rides;
CREATE TABLE heybuddy.rides
(ride_id bigint default nextval('heybuddy.seqIID') PRIMARY KEY,
pick_up_location VARCHAR ( 50 ),
drop_off_location VARCHAR ( 50 ),
pinCode bigint ,
vehicle_type smallint,
time bigint,
charges NUMERIC ( 999, 2 ),
no_of_seats smallint,
is_cancelled boolean default false,
username VARCHAR ( 50 ) REFERENCES heybuddy.users (username));