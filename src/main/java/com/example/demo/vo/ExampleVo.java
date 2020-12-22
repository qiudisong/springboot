package com.example.demo.vo;

import com.example.demo.config.converter.DateJsonDeserializer;
import com.example.demo.config.converter.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ExampleVo implements Serializable {
    private Integer integer;
    private String string;
    @JsonDeserialize(using = DateJsonDeserializer.class)
    @JsonSerialize(using = DateJsonSerializer.class)
    private Date date;
}
