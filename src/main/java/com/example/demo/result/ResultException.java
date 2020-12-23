package com.example.demo.result;

public class ResultException extends RuntimeException {
    private ResultVo resultVo;

    public ResultVo getResultVo() {
        return resultVo;
    }

    public ResultException(ResultVo resultVo) {
        super();
        initWithResultVo(resultVo);
    }

    private void initWithResultVo(ResultVo resultVo) {
        if (resultVo == null) {
            initWithResultEnum(null);
        } else {
            this.resultVo = resultVo;
        }
    }

    public ResultException(ResultEnum resultEnum) {
        super();
        initWithResultEnum(resultEnum);
    }

    private void initWithResultEnum(ResultEnum resultEnum) {
        if (resultEnum == null) {
            resultEnum = ResultEnum.CREATE_RESULT_EXCEPTION_ERROR;
        }
        initWithResultVo(new ResultVo(resultEnum));
    }
}
