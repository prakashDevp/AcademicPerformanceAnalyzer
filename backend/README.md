# AcademicPerformanceAnalyzer - Backend

This is a Spring Boot backend prepared for deployment on Render, configured to use Neon PostgreSQL.

Environment variables (set these on Render):
- SPRING_DATASOURCE_URL (e.g. jdbc:postgresql://host:5432/dbname)
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- PORT (optional)

Build & run:
```
./mvnw clean package
java -jar target/*.jar
```
