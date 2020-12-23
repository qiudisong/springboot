package com.example.demo.result;

import lombok.Getter;

@Getter
public class ResultVo<T> {
    //响应是否成功
    private Boolean success;
    //响应状态码
    private String code;
    //响应信息
    private String message;
    //详细信息
    private String detailMessage;
    //响应数据
    private T data;

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultVo(ResultEnum resultEnum) {
        this.success = resultEnum.getSuccess();
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.detailMessage = resultEnum.getDetailMessage();
    }

    //通用返回成功
    public static ResultVo ok() {
        return new ResultVo(ResultEnum.SUCCESS);
    }

    //通用返回失败，未知错误
    public static ResultVo unknownError() {
        return new ResultVo(ResultEnum.UNKNOWN_ERROR);
    }

    //通用返回失败，参数错误
    public static ResultVo paramError() {
        return new ResultVo(ResultEnum.PARAM_ERROR);
    }
}
