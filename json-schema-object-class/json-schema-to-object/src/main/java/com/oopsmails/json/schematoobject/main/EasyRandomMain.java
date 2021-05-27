package com.oopsmails.json.schematoobject.main;

import com.oopsmails.json.schematoobject.model.Employee;
import org.jeasy.random.EasyRandom;

public class EasyRandomMain {
    public static void main(String[] args) {
        EasyRandom easyRandom = new EasyRandom();
        Employee employee = easyRandom.nextObject(Employee.class);
        System.out.println(employee);
    }
}
