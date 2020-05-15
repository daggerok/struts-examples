# struts-examples [![Build Status](https://travis-ci.org/daggerok/struts-examples.svg?branch=master)](https://travis-ci.org/daggerok/struts-examples)
start struts XML routing project

## gradle

```bash
./gradlew ; ./gradlew :appRun &

http :8080/app/
http :8080/app/hello
http :8080/app/customers/list

./gradlew :appStop
```

## maven

```bash
./mvnw ; ./mvnw jetty:run &

http :8080/app/
http :8080/app/hello
http :8080/app/customers/list

./mvnw jetty:stop
```

## build and run all

```bash
./mvnw ; ./gradlew
docker-compose down -v ; ./gradlew ; docker-compose up --build --force-recreate --remove-orphans

http :8080/app/
http :8080/app/hello
http :8080/app/customers/list

http :8081/app/
http :8081/app/hello
http :8081/app/customers/list

docker-compose down -v --rmi local
```
