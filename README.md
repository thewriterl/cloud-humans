# Cloud Humans Core API

![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)
![Coverage Status](https://s3.amazonaws.com/assets.coveralls.io/badges/coveralls_100.svg)

Simple [Spring Boot](http://projects.spring.io/spring-boot/) app for evaluating Cloud Human's Pros.

## Requirements

For building and running the application you need:

- [Project SDK -> 11](http://www.oracle.com/technetwork/java/javase/downloads)
- [Maven 3.6.3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.

Firstly, run:

```shell
mvn install
```

One way is to execute the `main` method in the `com.cloudhumans.chcoreapi.ChCoreApiApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Running Tests

The application has Unit and Integration tests. To run the tests, simply use:

```shell
mvn test
```

Alternatively you can run `com.cloudhumans.chcoreapi.integration.ApplicationCalculatorIntegrationTests` and
`com.cloudhumans.chcoreapi.unit.ApplicationCalculatorUnitTests` on your IDE