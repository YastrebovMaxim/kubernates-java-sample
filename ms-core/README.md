# Simple spring-boot microservice with rest endpoints

Application has endpoints:
```
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
docker run --rm --name ms-core -p 8080:8080 -d kubernates-java-sample/ms-core:latest
```
### Check application 
```
curl localhost:8080/api/ping/World
```