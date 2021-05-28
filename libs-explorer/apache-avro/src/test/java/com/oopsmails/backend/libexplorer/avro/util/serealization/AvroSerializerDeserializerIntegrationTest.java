package com.oopsmails.backend.libexplorer.avro.util.serealization;

import com.oopsmails.backend.libexplorer.avro.model.Active;
import com.oopsmails.backend.libexplorer.avro.model.AvroHttpRequest;
import com.oopsmails.backend.libexplorer.avro.model.ClientIdentifier;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AvroSerializerDeserializerIntegrationTest {

    AvroSerializer avroSerializer;
    AvroDeserializer avroDeserializer;
    AvroHttpRequest request;

    @AfterAll
    public static void tearDown() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        avroSerializer = new AvroSerializer();
        avroDeserializer = new AvroDeserializer();

        ClientIdentifier clientIdentifier = ClientIdentifier.newBuilder()
                .setHostName("localhost")
                .setIpAddress("255.255.255.0")
                .build();

        List<CharSequence> employees = new ArrayList();
        employees.add("James");
        employees.add("Alice");
        employees.add("David");
        employees.add("Han");

        request = AvroHttpRequest.newBuilder()
                .setRequestTime(01l)
                .setActive(Active.YES)
                .setClientIdentifier(clientIdentifier)
                .setEmployeeNames(employees)
                .build();
    }

    @Test
    public void WhenSerializedUsingJSONEncoder_thenObjectGetsSerialized() {
        byte[] data = avroSerializer.serializeAvroHttpRequestJSON(request);
        assertTrue(Objects.nonNull(data));
        assertTrue(data.length > 0);
    }

    @Test
    public void WhenSerializedUsingBinaryEncoder_thenObjectGetsSerialized() {
        byte[] data = avroSerializer.serializeAvroHttpRequestBinary(request);
        assertTrue(Objects.nonNull(data));
        assertTrue(data.length > 0);
    }

    @Test
    public void WhenDeserializeUsingJSONDecoder_thenActualAndExpectedObjectsAreEqual() {
        byte[] data = avroSerializer.serializeAvroHttpRequestJSON(request);
        AvroHttpRequest actualRequest = avroDeserializer.deSerealizeAvroHttpRequestJSON(data);
        assertEquals(actualRequest, request);
        assertTrue(actualRequest.getRequestTime()
                == (request.getRequestTime()));
    }

    @Test
    public void WhenDeserializeUsingBinaryEncoder_thenActualAndExpectedObjectsAreEqual() {
        byte[] data = avroSerializer.serializeAvroHttpRequestBinary(request);
        AvroHttpRequest actualRequest = avroDeserializer.deSerealizeAvroHttpRequestBinary(data);
        assertEquals(actualRequest, request);
        assertTrue(actualRequest.getRequestTime()
                == (request.getRequestTime()));
    }

}

