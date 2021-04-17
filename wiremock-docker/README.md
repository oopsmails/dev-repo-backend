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

docker run --rm -d --name wiremock-demo -p 5050:5050 \
rodolpheche/wiremock:2.25.1 \
--port 5050


