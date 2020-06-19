# Teammates administration application

Prerequisites
-------------
* Java 11

Optional
-------------
* Docker

How to build and Run
--------------------
1) Import the project as a Java maven project. 
2) Run mvn clean install.
3) Run the application from TeammatesAdminApplication.java by running it as java application.
4) Application should start at port 8090 which is defined in application.yml.
5) It should be accessible now at http://localhost:8090

H2 Database
-----------
H2 database should be accessible at http://localhost:8090/h2 

Things to improve if given more time
------------------------------------
* Better Exception handling to be done.
* Test cases to be written for all the layers including service, repository and adapters etc.
* Java docs needs to be written for all the methods.
* Logging needs to be done.
