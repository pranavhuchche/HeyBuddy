DROP TABLE IF EXISTS heybuddy.users_products_interest;
CREATE TABLE heybuddy.users_products_interest
(username VARCHAR ( 50 ) REFERENCES heybuddy.users (username),
product_id bigint REFERENCES heybuddy.products (product_id));