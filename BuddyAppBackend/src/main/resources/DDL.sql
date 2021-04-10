SELECT 'DROP OWNED BY heybuddy CASCADE' FROM pg_roles WHERE rolname = 'heybuddy';
DROP USER IF EXISTS heybuddy;
CREATE USER heybuddy;
ALTER USER heybuddy WITH encrypted password 'heybuddy';
ALTER USER heybuddy WITH superuser;

DROP SCHEMA if EXISTS heybuddy CASCADE;
CREATE SCHEMA if NOT EXISTS heybuddy AUTHORIZATION heybuddy;
ALTER SCHEMA heybuddy OWNER TO heybuddy;

DROP SEQUENCE IF EXISTS heybuddy.seqIID CASCADE;
CREATE SEQUENCE heybuddy.seqIID start 1000;