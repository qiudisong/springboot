package com.example.demo.config.converter;

import java.util.Date;

import com.example.demo.util.DateUtil;
import org.springframework.core.convert.converter.Converter;

public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        return DateUtil.convert(source);
    }
}