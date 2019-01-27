# springboot-postgresql-onazure-sample
You can manage Azure Database for PostgreSQL with Spring Boot by using this sample.

## Requirement
- JDK 1.8
- Gradle 5.1.1
- Eclipse

## How to setup this sample

Create 

Let's git clone or downlaod this sample.

import this sample into Eclipse project like below.

Update 
````

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://<server-name>.postgres.database.azure.com:5432/postgres
spring.datasource.username=<login-name>@<server-name>
spring.datasource.password=<password>

````