package com.oopsmails.backend.libexplorer.avro.util;


import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.util.ArrayList;

public class AvroSchemaBuilder {

    public Schema createAvroHttpRequestSchema() {

        Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier")
                .namespace("com.oopsmails.backend.libexplorer.avro.model")
                .fields()
                .requiredString("hostName")
                .requiredString("ipAddress")
                .endRecord();

        Schema accountIdentifier = SchemaBuilder.record("AccountIdentifier")
                .namespace("com.oopsmails.backend.libexplorer.avro.model")
                .fields()
                .requiredString("accountNumber")
                .name("accountType")
                .type()
                .enumeration("AccountType")
                .symbols("SAVING", "CHECKING")
                .noDefault()
                .endRecord();

        Schema avroHttpRequest = SchemaBuilder.record("AvroHttpRequest")
                .namespace("com.oopsmails.backend.libexplorer.avro.model")
                .fields()

                .requiredLong("requestTime")

                .name("clientIdentifier")
                .type(clientIdentifier)
                .noDefault()

                .name("employeeNames")
                .type()
                .array()
                .items()
                .stringType()
                .arrayDefault(new ArrayList<>() {
                })

                .name("active")
                .type()
                .enumeration("Active")
                .symbols("YES", "NO")
                .noDefault()

                .name("accounts")
                .type()
                .array()
                .items()
                .type(accountIdentifier)
                .arrayDefault(new ArrayList<>() {
                })
                .endRecord();
        return avroHttpRequest;
    }
}


