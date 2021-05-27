package com.oopsmails.json.schematoobject.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.oopsmails.json.schematoobject.model.Employee;
import org.jeasy.random.EasyRandom;

public class EasyRandomMain {
    public static void main(String[] args) {
        try {
            EasyRandom easyRandom = new EasyRandom();
            Employee employee = easyRandom.nextObject(Employee.class);
            System.out.println(employee);

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter prettyPrinter = objectMapper.writerWithDefaultPrettyPrinter();

            String json = prettyPrinter.writeValueAsString(employee);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
