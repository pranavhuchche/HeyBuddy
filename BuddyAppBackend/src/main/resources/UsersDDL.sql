DROP TABLE IF EXISTS heyBuddy.users;
CREATE TABLE heyBuddy.users
(username VARCHAR ( 50 ) PRIMARY KEY,
name VARCHAR ( 100 ),
dob DATE,
bio VARCHAR ( 500 ),
mobile_number VARCHAR ( 20 ),
desk_location VARCHAR ( 10 ),
email VARCHAR ( 50 ),
--profile_picture,
hobbies VARCHAR ( 100 ));