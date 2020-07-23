FROM openjdk:8-jdk-alpine
COPY target/*.war app.war
COPY ./spread-dashboard.mv.db spread-dashboard.mv.db
COPY ./spread-dashboard.trace.db spread-dashboard.trace.db
ENTRYPOINT ["java","-jar","/app.war"]