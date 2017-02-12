package com.zoo.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * customize de_serialize the Animal list in Zoo class
 * 
 * Reference:
 * http://stackoverflow.com/questions/36380703/bad-request-when-sending-json-object-to-rest-service
 * http://stackoverflow.com/questions/11376304/right-way-to-write-json-deserializer-in-spring-or-extend-it
 *
 */
public class ZooDeserializer extends JsonDeserializer<List<Animal>> {

    @Override
    public List<Animal> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        List<Animal> animals = new ArrayList<Animal>();
        if (jsonNode.isArray()) {
            // you may have different serialization logic if you want
            for (JsonNode node : jsonNode) {
            	animals.add(new Animal(node.get("id").asInt(),node.get("name").asText()));
            }
        }
        return animals;
    }

}