package com.example.demo.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ExamplePo implements Serializable {
    private Integer integer;
    private String string;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",locale = "ch",timezone = "GMT+8")
    private Date date;
}
