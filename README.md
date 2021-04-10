#Hey Buddy Application

## PREREQUISITE
1. Maven should be installed.
2. A database with name 'heybuddy' should be created in postgres 11.

## Steps to start backend application on local system
1. Execute below commands on command promt at HeyBuddy\BuddyAppBackend location
   - mvn clean install -DskipTests
   - mvn eclipse:eclipse
   - mvn package -DskipTests
2. Execute below command to start the application
   - java -Xdebug -agentlib:jdwp=transport=dt_socket,address=9898,server=y,suspend=n -jar heybuddy-0.0.1.jar
3. Execute below URL for DB setup
   - Request Method : GET
   - Request URL : http://localhost:8080/heyBuddy/setupdb
   - If you're getting 'role \"heybuddy\" cannot be dropped because some objects depend on it' error while running above URL, please execute 'DROP OWNED BY heybuddy CASCADE;' query from pgadmin.