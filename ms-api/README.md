# Simple spring-boot microservice with rest endpoints

Application has endpoints:
```
GET /api/ping/{some string}
    Response: String
```

## Getting Started
### Installing

For installing project with test and build local docker image run commands:
```
./mvnw clean install
cd ms-api
docker build --build-arg JAR_FILE=target/api.jar -t kubernates-java-sample/api:v1 .
```
### Deployment
todo

### Running
```$xslt
docker run --name api-container -p 8080:8080 -d kubernates-java-sample/api:v1
```
### Check application 
```$xslt
curl localhost:8080/api/ping/World
```