FROM openjdk:8
EXPOSE 8080
ADD target/ATM-Project.jar ATM-Project.jar
ENTRYPOINT [ "java", "-jar", "/ATM-Project.jar"]