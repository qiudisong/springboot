package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

public class DateUtil {
    private static String[] pattern =
            new String[]{
                    "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
                    "yyyy.MM.dd", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd'T'HH:mm:ss.SSSZ",
                    "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd'T'HH:mm:ss.SSSZ"
            };

    public static Date convert(String source) {
        Date targetDate = null;
        if (StringUtils.isNotEmpty(source)) {
            try {
                long longDate = Long.valueOf(source.trim());
                targetDate = new Date(longDate);
            } catch (NumberFormatException e) {
                try {
                    targetDate = DateUtils.parseDate(source, pattern);
                } catch (ParseException pe) {
                    throw new RuntimeException(String.format(
                            "'%s' can not convert to type 'java.util.Date',just support timestamp(type of long) and following date format(%s)",
                            source,
                            StringUtils.join(pattern, ",")));
                }
            }
        }
        return targetDate;
    }
}