# Ledger

The project consists of a simple demonstration of an open REST API for posting financial transactions and their respective accounts, types and institutions.

This project is the result of studies and does not have implementations of security mechanisms. Therefore, it should be used for illustrative purposes only.

## Prerequisites

The following technologies must be previously installed:

* Java (JDK) >= 17.0.7
* Gradle >= 8.2.1
* PostgreSQL >= 14.9

The following technologies are dependencies present in the project:

* Spring Boot
* Spring Boot DevTools
* Spring Web
* Spring Data JPA
* Spring Data REST
* Liquibase
* Lombok

## Installation

First of all, you need to configure the database.
Define the connection data with your PostgreSQL database, in the `application.properties` file. Once this is done, it is necessary to run the command for Liquibase to carry out the migrations:

```sh
gradle update
```

Then just run Spring Boot to serve the API with the command:

```sh
gradle bootRun
```

## License

This project is open-sourced software licensed under the [MIT License](license.md).