DROP TABLE IF EXISTS heybuddy.users;
CREATE TABLE heybuddy.users
(username VARCHAR ( 50 ) PRIMARY KEY,
name VARCHAR ( 100 ),
dob DATE,
bio VARCHAR ( 500 ),
mobile_number VARCHAR ( 20 ),
desk_location VARCHAR ( 10 ),
email VARCHAR ( 50 ),
--profile_picture,
hobbies VARCHAR ( 100 ),
password VARCHAR ( 100 ));