package com.example.demo.config.converter;

import com.example.demo.util.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;

public class DateJsonDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser == null) {
            return null;
        }
        String text = null;
        try {
            text = jsonParser.getText();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        Date date = DateUtil.convert(text);
        return date;
    }
}