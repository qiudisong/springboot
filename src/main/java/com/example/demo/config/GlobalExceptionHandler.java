package com.example.demo.config;

import com.example.demo.config.Exception.ParamException;
import com.example.demo.util.ExceptionUtil;
import com.example.demo.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /*通用异常处理方法*/
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResultVo error(Throwable t) {
        log.error(ExceptionUtil.getMessage(t));
        return ResultVo.unknownError();
    }

    /*自定义异常处理方法*/
    @ExceptionHandler(ParamException.class)
    @ResponseBody
    public ResultVo error(ParamException e) {
        log.error(ExceptionUtil.getMessage(e));
        return ResultVo.paramError(e.getMessage());
    }
}
