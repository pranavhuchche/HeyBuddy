DROP TABLE IF EXISTS heybuddy.products;
CREATE TABLE heybuddy.products
(product_id serial PRIMARY KEY,
product_name VARCHAR ( 50 ),
description VARCHAR ( 200 ),
--images,
mobile_number VARCHAR ( 20 ),
cost_from NUMERIC ( 2 ),
cost_to NUMERIC ( 2 ),
--payment options,
status BOOLEAN,
listing_date DATE,
listing_type smallint,
username VARCHAR ( 50 ) REFERENCES heybuddy.users (username));