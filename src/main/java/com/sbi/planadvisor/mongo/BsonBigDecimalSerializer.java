package com.sbi.planadvisor.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.undercouch.bson4jackson.BsonGenerator;
import de.undercouch.bson4jackson.serializers.BsonSerializer;

import java.io.IOException;
import java.math.BigDecimal;

public class BsonBigDecimalSerializer extends BsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal bigDecimal, BsonGenerator bsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        bsonGenerator.writeNumber(bigDecimal.doubleValue());
    }
}
