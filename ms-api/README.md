# Simple spring-boot microservice with rest endpoints.

Microservice  interacts with core-ms.
Application has endpoints:
```
GET /api/ping/{some string}
    Response: String

GET /api/random/genearte/{some string}
    Response: {String randomString, Integer randomInt}
```

## Getting Started
### Installing

For installing project with test and build local docker image run commands:
```
./mvnw clean install
```
### Deployment
todo

### Running
```
docker run --rm --name ms-api -p 8080:8080 -d kubernates-java-sample/ms-api:latest
```
### Check application 
```
curl localhost:8080/api/ping/World
```