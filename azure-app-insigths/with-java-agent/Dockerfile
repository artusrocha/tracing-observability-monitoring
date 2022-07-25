FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /app
COPY ./.mvn/ .mvn
COPY ./mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install
 
 
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/*.jar ./app.jar
COPY ./monitor ./
ENTRYPOINT ["java", "-javaagent:/app/applicationinsights-agent-3.3.0.jar", "-jar", "app.jar" ]