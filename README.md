# springboot-postgresql-onazure-sample
You can manage Azure Database for PostgreSQL with Spring Boot by using this sample.

## Requirement
- JDK 1.8
- Gradle 5.1.1
- Eclipse
- Microsoft Azure subscription

## How to setup this sample

Create your Azure Database for PostgreSQL instance like below. Note to save your "server name", "login name" and "password" to setup your Spring Boot sample later.
![fig01.png](img/fig01.png "fig01.png")

Add your local machine IP address into allow list of your PostgreSQL instance like below if you want to test from your machine. 
![fig02.png](img/fig02.png "fig02.png")

Let's git clone or downlaod this sample and import this sample into your Eclipse workspace like below.
![fig11.png](img/fig11.png "fig11.png")

Update "springboot-postgresql-onazure-sample\src\main\resources\application.properties" to access your PostgreSQL instance properly.

````

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://<server-name>.postgres.database.azure.com:5432/postgres
spring.datasource.username=<login-name>@<server-name>
spring.datasource.password=<password>

````

Now, you can execute your Spring Boot sample!