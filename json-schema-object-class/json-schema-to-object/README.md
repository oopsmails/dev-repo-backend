# json-schema-to-object

## fake-schema-cli

https://github.com/atomsfat/fake-schema-cli#readme

## other

https://stackoverflow.com/questions/60572396/how-to-generate-json-data-from-json-schema-programmatically-in-java

- POJOs

If you already have the POJOs matching the schema, then we can skip this step. If no, to generate a POJO from the schema, for example, can be used this library: jsonschema2pojo.

- Fake objects

Generating of objects with fake data can be done with a special library, some of them are listed here:

    - easy-random
    EasyRandomMain.java, ok
    - podam
    - java-faker

- Generating JSON

It's prettry simple and can be done with Jackson:

ObjectMapper objectMapper = new ObjectMapper();
ObjectWriter prettyPrinter = objectMapper.writerWithDefaultPrettyPrinter();
String json = prettyPrinter.writeValueAsString(yourFakeObject);


- If you have json schema then you can directly generate a sample JSON message from it.

https://github.com/jignesh-dhua/json-generator
