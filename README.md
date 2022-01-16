# Cloud Humans Core API

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)

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
