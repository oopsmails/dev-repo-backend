# Mocking APIs with WireMock and Docker

- Ref:

https://medium.com/@jw_ng/mocking-with-wiremock-and-docker-1f1601bd10e4

## docker command

```
docker pull rodolpheche/wiremock:2.25.1 # latest as of writing


docker run \
--rm \
-d \
-p 8080:8080 -p 8443:8443 \
--name wiremock-demo \
rodolpheche/wiremock:2.25.1


docker ps | grep wiremock-demo

```

- change ports

```
docker run --rm -d --name wiremock-demo -p 5050:5050 \
rodolpheche/wiremock:2.25.1 \
--port 5050
```

## docker compose

- connect to container

`docker container exec -it wiremock-docker_wiremock_1 /bin/bash`

- endpoint

http://localhost:7070/hello
  
- swagger
  
http://localhost:7070/__admin/swagger-ui/

- reference

https://stackoverflow.com/questions/63532189/docker-container-with-wiremock-does-not-refresh-changes-from-volume

As per my knowledge the wiremock standalone java process does the followings (regardless if it runs on the host or in a container):

    - automatically loads the latest changes in the response bodies files (from __files folder)

    - requires a POST call to __admin/mappings/reset in order to reload the mappings. For the example in the question description the cURL command looks like curl -X POST http://localhost:7070/__admin/mappings/reset

### very helpful reference

https://stackoverflow.com/questions/50360947/how-to-enable-response-templating-on-a-wiremock-servlet

- If you would like to use wiremock with docker, I have a sample docker-compose.yaml here with verbose logging and templating.

- Spin up Wiremock in a docker container with docker-compose up.

docker-compose.yaml sample:

```
version: "3"
services:
wiremock:
image: rodolpheche/wiremock:latest
ports:
- "8181:8080"
volumes:
- ./__files/:/./home/wiremock/__files/
- ./mappings/:/./home/wiremock/mappings/
command:
- -verbose
- -global-response-templating
docker-compose up (in the directory you saved the yaml, and accept the requests for filesystem access) then you should be ready to go.
```

- Wiremock url would be http://localhost:8181

- After that do a recording with real data (http://localhost:8181/__admin/recorder)

- Split the body to a separate file and place it in the __files folder. Point to the file with ""bodyFileName" in the request file (mappings)

- I have some suggestions here. mobileera_wiremock_kb, see wiremock-docker/Wiremock.pdf

