package com.example.demo.result;

import lombok.Getter;

@Getter
public enum ResultEnum {
    CREATE_RESULT_EXCEPTION_ERROR(false, "20003", "创建ResultException错误"),
    PARAM_ERROR(false, "20002", "参数错误"),
    UNKNOWN_ERROR(false, "20001", "未知错误"),
    SUCCESS(true, "20000", "成功");

    //响应是否成功
    private Boolean success;
    //响应状态码
    private String code;
    //响应码信息
    private String message;

    ResultEnum(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
