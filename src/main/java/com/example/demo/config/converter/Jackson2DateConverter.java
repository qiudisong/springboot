package com.example.demo.config.converter;

import com.example.demo.util.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.util.Date;

public class Jackson2DateConverter extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser p, DeserializationContext deserializationContext) {
        String originDate;
        try {
            originDate = p.getText();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
        return DateUtil.convert(originDate);
    }

    @Override
    public Class<?> handledType() {
        return Date.class;
    }
}