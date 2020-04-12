FROM maven:3.6.3-jdk-11 AS builder

WORKDIR /app
ADD pom.xml /app
RUN mvn dependency:go-offline

FROM builder
COPY . /app
RUN mvn clean install -DskipTests -e

ENTRYPOINT ["java","-jar","/app/target/etesdadokit-0.0.1-SNAPSHOT.jar"]
