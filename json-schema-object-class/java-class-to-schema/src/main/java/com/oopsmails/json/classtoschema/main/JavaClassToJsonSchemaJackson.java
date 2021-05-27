package com.oopsmails.json.classtoschema.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import com.oopsmails.json.classtoschema.model.Employee;

public class JavaClassToJsonSchemaJackson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
            mapper.acceptJsonFormatVisitor(Employee.class, visitor);
            JsonSchema schema = visitor.finalSchema();
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
