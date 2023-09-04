Flyway

- Flyway plugin installed and configured in gradle
- The flywayMigrate task executes scripts in ./db/migrations folder in the correct order by version
    - flyway scripts have to follow certain naming convention
- The flywayClean task can remove all objects from database schema and let you start over again
- The flywayInfo task shows current migration status on the subject database