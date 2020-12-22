package com.example.demo.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ExamplePo implements Serializable {
    private Integer integer;
    private String string;
    private Date date;
}
