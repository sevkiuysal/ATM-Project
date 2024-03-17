FROM openjdk:17
EXPOSE 8080
ADD target/atm-project.jar atm-project.jar
ENTRYPOINT [ "java", "-jar", "/atm-project.jar"]