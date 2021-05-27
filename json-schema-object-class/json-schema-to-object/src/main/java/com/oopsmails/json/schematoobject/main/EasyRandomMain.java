package com.oopsmails.json.schematoobject.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.oopsmails.json.schematoobject.model.Employee;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.TypePredicates;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import static java.nio.charset.Charset.forName;

/**
 * https://github.com/j-easy/easy-random
 *
 * <dependency>
 *     <groupId>org.jeasy</groupId>
 *     <artifactId>easy-random-core</artifactId>
 *     <version>4.0.0</version>
 * </dependency>
 *
 * EasyRandomParameters parameters = new EasyRandomParameters()
 *    .seed(123L)
 *    .objectPoolSize(100)
 *    .randomizationDepth(3)
 *    .charset(forName("UTF-8"))
 *    .timeRange(nine, five)
 *    .dateRange(today, tomorrow)
 *    .stringLengthRange(5, 50)
 *    .collectionSizeRange(1, 10)
 *    .scanClasspathForConcreteTypes(true)
 *    .overrideDefaultInitialization(false)
 *    .ignoreRandomizationErrors(true);
 *
 * EasyRandomParameters parameters = new EasyRandomParameters()
 *    .randomize(String.class, () -> "foo")
 *    .excludeField(named("age").and(ofType(Integer.class)).and(inClass(Person.class)));
 *
 * parameters.excludeField(FieldPredicates.named("lastName").and(FieldPredicates.inClass(Employee.class)));
 * parameters.excludeType(TypePredicates.inPackage("not.existing.pkg"));
 * parameters.randomize(YearQuarter.class, new YearQuarterRandomizer());
 *
 *
 */


public class EasyRandomMain {
    public static void main(String[] args) {
        try {
            EasyRandomParameters parameters = new EasyRandomParameters()
                    .seed(123L)
                    .objectPoolSize(100)
                    .randomizationDepth(3)
                    .charset(forName("UTF-8"))
                    .stringLengthRange(5, 50)
                    .collectionSizeRange(1, 10)
                    .scanClasspathForConcreteTypes(true)
                    .overrideDefaultInitialization(false)
                    .ignoreRandomizationErrors(true);

            Random random = new Random();
            parameters.randomize(BigDecimal.class, () -> new BigDecimal(BigInteger.valueOf(random.nextInt(100001)), 2));
            parameters.randomize(int.class, () -> random.nextInt(1200 - 55) + 55);
            parameters.randomize(Integer.class, () -> random.nextInt(1200 - 55) + 55);
            parameters.randomize(long.class, () -> 10L + (long) (Math.random() * (1888L - 10L)));
            parameters.randomize(Long.class, () -> 10L + (long) (Math.random() * (1888L - 10L)));

            parameters.excludeType(TypePredicates.ofType(EasyRandomMain.class)); // e.g, exclude for no default constructor

            EasyRandom easyRandom = new EasyRandom(parameters);
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
