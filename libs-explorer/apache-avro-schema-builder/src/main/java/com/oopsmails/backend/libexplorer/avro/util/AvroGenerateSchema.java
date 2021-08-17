package com.oopsmails.backend.libexplorer.avro.util;

import org.apache.avro.Schema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AvroGenerateSchema {
    public static void main(String[] args) {
        final String OUTPUT_PATH = "C:\\sharing\\github\\dev-repo-backend\\libs-explorer\\apache-avro-schema-builder\\src\\main\\resources\\";
        final String AVRO_SCHEMA_NAME = "avroHttpRequest-schema.avsc";
        try {
            AvroSchemaBuilder avroSchemaBuilder = new AvroSchemaBuilder();
            Schema schema = avroSchemaBuilder.createAvroHttpRequestSchema();

            String schemaStr = schema.toString(true);
            System.out.format(schemaStr);
            Files.write(Paths.get(OUTPUT_PATH + AVRO_SCHEMA_NAME), schemaStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
