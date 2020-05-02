package com.example.demo.config;

import com.example.demo.config.Exception.ParamException;
import com.example.demo.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /*通用异常处理方法*/
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResultVo error(Throwable t){
        t.printStackTrace();
        return ResultVo.unknownError();
    }

    /*自定义异常处理方法*/
    @ExceptionHandler(ParamException.class)
    @ResponseBody
    public ResultVo error(ParamException e){
        e.printStackTrace();
        return ResultVo.paramError(e.getMessage());
    }
}
