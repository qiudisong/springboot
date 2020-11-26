package com.example.demo.config;

import com.example.demo.result.ResultException;
import com.example.demo.util.ExceptionUtil;
import com.example.demo.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /*通用异常处理方法*/
    @ExceptionHandler(Throwable.class)
    public ResultVo throwable(Throwable t) {
        log.error(ExceptionUtil.getMessage(t));
        return ResultVo.unknownError();
    }

    /*自定义异常处理方法*/
    @ExceptionHandler(ResultException.class)
    public ResultVo resultException(ResultException e) {
        log.error(ExceptionUtil.getMessage(e));
        ResultVo resultVo = e.getResultVo();
        return resultVo;
    }
}
