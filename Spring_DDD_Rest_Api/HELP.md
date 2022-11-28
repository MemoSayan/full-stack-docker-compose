# Getting Started

Project Spring DDD Api Rest Employee Manager
=======================
A sample project following Domain Driven Design with Spring Data JPA
                    (C) Guillermo De La Cruz, 2022-11-18 ... 2022-11-19

In this project I am trying to apply principles of Domain Driven Design.
In contrary to more complex DDD examples on the web I am applying here some simplifications.
This sample application has been developed for a apply to a job at Hahn Softwareentwicklung GmbH.

This project uses.

- JDK 11 as the platform
- - [Maven](https://maven.apache.org/) 3 as build tool
- [Spring Boot](https://spring.io/projects/spring-boot) 2 as enterprise framework and web server
- [Spring Data](https://spring.io/projects/spring-data) + [JPA](https://en.wikipedia.org/wiki/Jakarta_Persistence) + [Hibernate](https://hibernate.org/) as persistence API and object-relational mapper
- 


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#using.devtools)
* - [H2 Database Engine](https://www.h2database.com/html/main.html) as relational database only for dev proposites.

Detailed version indications you can find in the file [pom.xml](pom.xml).

## Usage

If the correct JDK and Maven versions are installed you can simply use
`mvn clean package site`
his will fetch all necessary libraries, compile the project, collect the exception message texts,
execute the test suite, package all into an executable .jar file, and generate the reports and project site.

You can run the application (a REST server) in your IDE by running class [mx.com.ddd.spring](src\main\java\mx\com\ddd\spring\SpringDddRestApiApplication.java) as Java Application or on the command line after
`mvn package` by
`java -jar target/Spring_DDD_Rest_Api-0.0.1-SNAPSHOT.jar`

This will start the web server Tomcat with the web application *Spring DDD Employee*. 
`Tomcat started on port(s): 8080 (http)`

## Which DDD principles are implemented?
- Modeling the domain layer as one package, which does not depend on any other package besides standard Java SE packages as `java.time` and `javax.persistence`. The latter only for the JPA annotations.
- Prefer a [Rich Domain Model](https://www.amido.com/blog/anaemic-domain-model-vs-rich-domain-model) over an [Anemic Domain Model](https://martinfowler.com/bliki/AnemicDomainModel.html) by having relevant business logic methods in entity class Employee.
-  Implementing required services in the infrastructure layer with posibilities of add custom methods.
- Linking together required services and their implementations by Spring Dependency Injection.