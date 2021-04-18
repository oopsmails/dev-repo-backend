package com.oopsmails.mavenplugins.jsd2pojoext;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import lombok.AllArgsConstructor;
import org.jsonschema2pojo.AbstractAnnotator;

import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class LombokAnnotator extends AbstractAnnotator {
    public static Map<String, Class> annotationClassMap = Map.of(
            "lombok-builder",Builder.class,
            "lombok-data", Data.class,
            "lombok-getter", Getter.class,
            "lombok-setter", Setter.class,
            "lombok-equals-and-hash-code", EqualsAndHashCode.class,
            "lombok-no-args-constructor", NoArgsConstructor.class,
            "lombok-all-args-constructor", AllArgsConstructor.class,
            "lombok-to-string", ToString.class
    );

    @Override
    public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {

        JsonNode additionalProperties = schema.get("additionalProperties");

        try {
            additionalProperties.fieldNames().forEachRemaining(property -> {
                System.out.println("LombokAnnotator, property = " + property);
                Class annotation = annotationClassMap.get(property);
                if (!annotation.equals(IllegalArgumentException.class)) {
                    clazz.annotate(annotation);
                }
            });
        } catch (NullPointerException e) {
            System.out.println(String.format("No additionalProperties defined for %s.", clazz.fullName()));
        }

    }

    @Override
    public boolean isAdditionalPropertiesSupported() {
        return false;
    }

}
