# Workman

An illustration of workflow management using different type of tasks (script , scheduled, etc.)

## Setup

For the first run add the following environment variables:
```
spring.jpa.hibernate.ddl-auto: create
spring.datasource.initialization-mode: embedded
```


Add datasource configuration to your environment:

```
spring.datasource.username: USERNAME
spring.datasource.password: PASSWORD
spring.datasource.url: jdbc:h2:file:D:\path\to\file
```

If you need to build locally the project, do a maven install on the following order : 
* workman-core
* workman-domain
* workman-spring-starter
* workman-application
* workman

To run the application execute `cd workman && ../mvnw spring-boot:run` and go to http://localhost:8080


## Structure
Implementing an hexagonal architecture of 3 levels:

### domain 
**workman-domain** : contain only the description and action on the domain entities (task definitions, transitions, business processes)
### application
**workman-application** : handle domain entities and illustrate use cases
### adapter
**workman** : contain entries to the application ( endpoints and repositories)

### technical layers
**workman-core**: contains workflow implementation and some generic abstractions
**workman-spring-starter**: add necessary spring annotations to generate repositories and controllers

