package com.example.demo.config.converter;

import com.example.demo.util.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.util.Date;

public class Jackson2DateConverter extends JsonDeserializer<Date> {
    private static String[] pattern =
            new String[]{
                    "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
                    "yyyy.MM.dd", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd'T'HH:mm:ss.SSSZ",
                    "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd'T'HH:mm:ss.SSSZ"
            };

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