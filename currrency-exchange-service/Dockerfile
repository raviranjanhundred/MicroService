# Build a jar File
FROM maven:3.8.1-jdk-11 AS build
WORKDIR /home/ravi/app
COPY pom.xml /home/ravi/app
RUN mvn dependency:go-offline -B
COPY . /home/ravi/app
RUN mvn clean package -DskipTests

#Create an Image
FROM openjdk:18-oracle
EXPOSE 5000
COPY --from=build /home/ravi/app/target/currrency-exchange-service-1.0.0.jar currrency-exchange-service-1.0.0.jar
CMD ["java", "-jar", "/currrency-exchange-service-1.0.0.jar"]
