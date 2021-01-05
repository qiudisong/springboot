package com.example.demo.po;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeptPo {
    private Integer id;
    private Integer parentId;
    private String name;
}
