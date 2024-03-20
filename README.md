# ATM-Project
This project's aim is digital banking operations. This operations are user(sign up, sign in, add money, draw money and send money) and admin(sign up, sign in and follow up users).

# Technology

* Java 17
* Spring Boot 3.2.1
* Spring Web
* Spring Security
* Spring Data Jpa
* Spring Boot DevTools
* PostqreSQL Driver
* Swagger UI
* Docker

# Dockerizing Project

- Create Dockerfile and docker-compose.yaml

- Maven clean and install

 ```PowerShell
 mvn clean install
 ```
- Build docker images from Dockerfile

 ```PowerShell
 docker build -t atm-project.jar .
 ```
 - Build docker-compose

 ```PowerShell
 docker-compose build
 ```
- Run docker-compose 

 ```PowerShell
 docker-compose up
 ```

- When we list the available docker images:

 ```PowerShell
 docker image ls -a
 ```
 
- When we list the all containers:

 ```PowerShell
 docker ps -a
 ```