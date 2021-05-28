# Learning Apache Avro

- Ref:

https://www.baeldung.com/java-apache-avro

## How this works

- apache-avro-schema-builder

    - Run *libs-explorer/apache-avro-schema-builder/src/main/java/com/oopsmails/backend/libexplorer/avro/util/AvroGenerateSchema.java* first.
    - The avro schema file, *avroHttpRequest-schema.avsc*, will be generated under *src/resources*
    
- apache-avro-class-generator

    - Copy *avroHttpRequest-schema.avsc* from *apache-avro-schema-builder* to this project, under *src/resources*
    - Run mvn install, all model classes will be generated.
    
- apache-avro

    - This project has a dependency on *apache-avro-class-generator*, using generated model classes
    - Test avro Deserializer and Serializer

