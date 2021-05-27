package com.smartentities.json.generator.generators;

import org.everit.json.schema.EnumSchema;
import org.everit.json.schema.Schema;

import java.util.Collections;
import java.util.List;

public class EnumGenerator extends JsonValueGenerator<Object> {

    public EnumGenerator(Schema schema) {
        super(schema);

    }

    @Override
    public Object generate() {
//        List<Object> possibleValuesAsList = ((EnumSchema) schema).getPossibleValuesAsList();
        List<Object> possibleValuesAsList = Collections.singletonList(((EnumSchema) schema).getPossibleValues());
        return possibleValuesAsList.get(0);
    }
}
