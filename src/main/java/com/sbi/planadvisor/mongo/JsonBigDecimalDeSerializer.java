package com.sbi.planadvisor.mongo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

public class JsonBigDecimalDeSerializer extends JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Object deserialized = p.getEmbeddedObject();
        if (deserialized instanceof Double) {
            BigDecimal bd = new BigDecimal((Double) deserialized, MathContext.DECIMAL32);
            bd = bd.setScale(2);
            return bd;
        }
        throw new RuntimeException("conversion not supported BigDecimal from " + deserialized.getClass());
    }
}
