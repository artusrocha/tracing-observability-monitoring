FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install
 
 
FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/app.jar
COPY ./monitor /opt/app/monitor
ENTRYPOINT ["java", "-javaagent:/opt/app/applicationinsights-agent-3.3.0.jar", "-jar", "/opt/app/app.jar" ]