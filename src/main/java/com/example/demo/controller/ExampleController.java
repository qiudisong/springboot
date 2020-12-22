package com.example.demo.controller;

import com.example.demo.result.ResultEnum;
import com.example.demo.result.ResultException;
import com.example.demo.service.ExampleService;
import com.example.demo.vo.ExampleVo;
import com.example.demo.result.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping(value = "/example")
public class ExampleController {
    @Resource
    private ExampleService exampleService;

    @RequestMapping(value = "/restful", method = {RequestMethod.GET})
    @ResponseBody
    public String restful() {
        return "success";
    }

    @RequestMapping(value = "/requestParam", method = {RequestMethod.GET})
    @ResponseBody
    public ResultVo<ExampleVo> requestParam(
            @RequestParam Integer integer
            , @RequestParam String string
            , @RequestParam Date date
    ) {
        ExampleVo exampleVo = new ExampleVo()
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        ResultVo resultVo = ResultVo.ok();
        resultVo.setData(exampleVo);
        return resultVo;
    }

    @RequestMapping(value = "/pathVariable/{integer}/{string}/{date}", method = {RequestMethod.GET})
    @ResponseBody
    public ResultVo<ExampleVo> pathVariable(
            @PathVariable Integer integer
            , @PathVariable String string
            , @PathVariable Date date
    ) {
        ExampleVo exampleVo = new ExampleVo()
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        ResultVo resultVo = ResultVo.ok();
        resultVo.setData(exampleVo);
        return resultVo;
    }

    @RequestMapping(value = "/requestBody", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo<ExampleVo> requestBody(
            @RequestBody ExampleVo exampleVo
    ) {
        ResultVo resultVo = ResultVo.ok();
        resultVo.setData(exampleVo);
        return resultVo;
    }

    @RequestMapping(value = "html", method = {RequestMethod.GET})
    public String html() {
        return "/index.html";
    }

    @RequestMapping(value = "jsp", method = {RequestMethod.GET})
    public String jsp() {
        return "/index.jsp";
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo<ExampleVo> selectByPrimaryKey(
            @RequestParam int id
    ) {
        ExampleVo exampleVo = exampleService.selectByPrimaryKey(id);
        ResultVo resultVo = ResultVo.ok();
        resultVo.setData(exampleVo);
        return resultVo;
    }

    @RequestMapping(value = "/throwRuntimeException", method = {RequestMethod.POST})
    @ResponseBody
    public void throwRuntimeException() {
        throw new RuntimeException();
    }

    @RequestMapping(value = "/throwResultException", method = {RequestMethod.POST})
    @ResponseBody
    public void throwResultException() {
        ResultEnum resultEnum = null;
        throw new ResultException(resultEnum);
    }
}
