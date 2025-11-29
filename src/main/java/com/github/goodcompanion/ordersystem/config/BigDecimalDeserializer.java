package com.github.goodcompanion.ordersystem.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Кастомный десериализатор для BigDecimal
 * Позволяет принимать числа как Double в JSON и конвертировать в BigDecimal
 */
public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        if (node.isNumber()) {
            return BigDecimal.valueOf(node.asDouble());
        } else if (node.isTextual()) {
            return new BigDecimal(node.asText());
        }
        return null;
    }
}
