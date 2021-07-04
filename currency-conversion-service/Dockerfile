# Build a jar File
FROM maven:3.8.1-jdk-11 AS build
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

#Create an Image
FROM openjdk:18-oracle
EXPOSE 5000
COPY --from=build /home/app/target/currency-conversion-service.jar currency-conversion-service.jar
ENTRYPOINT ["sh" "-c" "java -jar /currency-conversion-service.jar"]
