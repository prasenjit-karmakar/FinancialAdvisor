package com.sbi.planadvisor.mongo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class JsonInstantDeserializer extends JsonDeserializer<Instant> {

	@Override
	public Instant deserialize(
			JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Object deserialized = jp.getEmbeddedObject();
        if (deserialized instanceof Long) {
            return Instant.ofEpochMilli((Long)deserialized);
        }else if(deserialized instanceof String && !deserialized.equals("")){
            return Instant.ofEpochMilli(new Date((String)deserialized).getTime());
        }
        return ((Date)deserialized).toInstant();
	}

}
