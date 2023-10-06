# DDD, CleanArch and CQRS microservice cloud - TTeams

### Description ###
This project is a microservices cloud that implements the Domain Driven Design, Clean Arch, and Command Query Responsibility Segregation architectural patterns. It also has CI/CD Continuous Integration through Actions to facilitate the publication of the images of each microservice in a public Docker Hub repository. In addition, the project has its docker-compose file for a quick start-up of the microservices cloud.

### Project structure ###

<img src="https://github.com/RivasB/TTeams/blob/main/project.png"/>

### Install ###

```
git clone https://github.com/RivasB/TTeams.git
cd ddd-microservices
docker-compose up -d
```
API runs under http://localhost:8091

Check the Postman collection provided.

The default credentials are:
```
{
  identification: 0000000000,
  password: Password*777
}
```

OpenApi Documentation runs under http://localhost:8084/swagger-ui/index.html (auth free)

### Project docker repository  ###

https://hub.docker.com/repositories/rivasb

