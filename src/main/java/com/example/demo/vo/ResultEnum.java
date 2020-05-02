package com.example.demo.vo;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(true,"20000","成功"),
    UNKNOWN_ERROR(false,"20001","未知错误"),
    PARAM_ERROR(false,"20003","参数错误"),
    ;

    //响应是否成功
    private Boolean success;
    //响应状态码
    private String code;
    //响应信息
    private String message;

    ResultEnum(boolean success,String code,String message){
        this.success=success;
        this.code=code;
        this.message=message;
    }
}
