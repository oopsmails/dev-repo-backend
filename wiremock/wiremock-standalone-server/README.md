# wiremock/wiremock-standalone-server

- Ref:

https://www.softwaretestinghelp.com/wiremock-tutorial/

## A Standalone Wiremock Server

- Run, java -jar wiremock-standalone-2.25.1.jar
- Now once the server starts, you can visit any URL on localhost:8080  
For Example, http://localhost:8080/get/user/1. 
  As currently there are no mocks being set, will get default response "No response ..."
- Now let’s try setting up a simple stub/mock for this URL and try hitting back the URL again.
```
curl -X POST --data 
'{ "request": { "url": "/get/user/1", "method": "GET" },
"response": { "status": 200, "body": "Here it is!\n" }}'
 http://localhost:8080/__admin/mappings/new
```

