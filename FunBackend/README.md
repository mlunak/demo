### Controller

- [FunController](./src/main/kotlin/cz/capgemini/javateam/controller/FunController.kt)
    - controller with some endpoints
    - Advice for some exception handling
    - presentable through [OpenAPI](./src/main/kotlin/cz/capgemini/javateam/config/OpenAPIConfig.kt)

### Logging

- SLF4J logging configured in [logback](./logback-spring.xml)
- logging enabled for Console as well as rolling File
- [LoggingInterceptor](./src/main/kotlin/cz/capgemini/javateam/logging/LoggingInterceptor.kt)
    - counts execution time
- [LoggingFilter](./src/main/kotlin/cz/capgemini/javateam/logging/LoggingFilter.kt)
    - logs incoming HTTP requests and outgoing responses

### Interceptors

- [SecurityInterceptor](./src/main/kotlin/cz/capgemini/javateam/core/SecurityInterceptor.kt)
    - validates header token
- [FunInterceptor](./src/main/kotlin/cz/capgemini/javateam/core/FunInterceptor.kt)
    - counts incoming requests, prepares surprise

### Services

- [FunService](./src/main/kotlin/cz/capgemini/javateam/service/FunService.kt) provides two versions
    - V1 returns data from database
    - V2 does the same but has a surprise in it

### Flyway

- Flyway plugin installed and configured in gradle
- The flywayMigrate task executes scripts in ./db/migrations folder in the correct order by version
    - flyway [scripts](./db/migrations/V1_0__InitFun.sql) have to follow certain naming convention
- The flywayClean task can remove all objects from database schema and let you start over again
- The flywayInfo task shows current migration status on the subject database
- SpringBoot launches Flyway migration automatically unless you disable it in application.yml - spring.flyway.enable:
  false

### Some ideas to do

- encrypt passwords in configuration files
- create more endpoints and services
- populate database with some mechanism
    - SpringBatch combined with Kafka on some public topic