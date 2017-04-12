package com.sbi.planadvisor.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.undercouch.bson4jackson.BsonGenerator;
import de.undercouch.bson4jackson.serializers.BsonSerializer;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class BsonInstantSerializer extends BsonSerializer<Instant> {

	@Override
	public void serialize(
			Instant t, 
			BsonGenerator bsonGenerator,
			SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		bsonGenerator.writeDateTime(Date.from(t));
	}

}
