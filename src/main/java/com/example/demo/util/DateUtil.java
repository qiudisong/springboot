package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String[] pattern =
            new String[]{
                    "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss.SSS",
                    "yyyy.MM.dd", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd'T'HH:mm:ss.SSSZ", "yyyy.MM.dd'T'HH:mm:ss.SSS'Z'", "yyyy.MM.dd'T'HH:mm:ss.SSS",
                    "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd'T'HH:mm:ss.SSSZ", "yyyy/MM/dd'T'HH:mm:ss.SSS'Z'", "yyyy/MM/dd'T'HH:mm:ss.SSS"
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

    public static String convert(Date source) {
        String targetDate = null;
        if (source != null) {
            targetDate = format.format(source);
        }
        return targetDate;
    }
}