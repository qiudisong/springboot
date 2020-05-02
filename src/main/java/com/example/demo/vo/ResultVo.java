package com.example.demo.vo;

public class ResultVo<T> {
    //响应是否成功
    private Boolean success;
    //响应状态码
    private String code;
    //响应信息
    private String message;
    //响应数据
    private T data;

    private ResultVo<T> setData(T data) {
        this.data = data;
        return this;
    }

    private ResultVo(ResultEnum resultEnum) {
        this.success = resultEnum.getSuccess();
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    //通用返回成功
    public static ResultVo ok() {
        return new ResultVo(ResultEnum.SUCCESS);
    }

    //通用返回成功(带响应数据)
    public static <T> ResultVo<T> ok(T data) {
        return ok().setData(data);
    }

    //通用返回失败，未知错误
    public static ResultVo unknownError() {
        return new ResultVo(ResultEnum.UNKNOWN_ERROR);
    }

    //通用返回失败，未知错误(带响应数据)
    public static <T> ResultVo<T> unknownError(T data) {
        return unknownError().setData(data);
    }

    //通用返回失败，参数错误
    public static ResultVo paramError() {
        return new ResultVo(ResultEnum.PARAM_ERROR);
    }

    //通用返回失败，未知错误(带响应数据)
    public static <T> ResultVo<T> paramError(T data) {
        return paramError().setData(data);
    }

}
