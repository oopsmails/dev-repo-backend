# codegen-openapi

- Ref

https://wstutorial.com/rest/spring-boot-openapi-codegen.html

## codegen-openapi-test

Use OpenAPI Generator CLI

OpenAPI Generator's CLI is a command-line tool.

java -jar openapi-generator-cli-4.3.1.jar generate -g spring -i openapi.yaml -c conf.json -o spring-boot-codegenerator

java -jar openapi-generator-cli-4.3.1.jar generate -g spring -i openapi.yaml -c conf.json -o ../../codegen-openapi-test

## codegen-openapi-maven-tutorialapi

- Generate codes using maven
- Unlike the cli case, we want to prevent the Docket configuration class from being generated. For that reason we added the option interfaceOnly = true

Info! Without setting interfaceOnly = true the generator was trying to generate a OpenAPIDocumentationConfig class.
We are not sure if this way the best one to solve this "challenge", but it worked for us. If you have a better solution, please let us know.


