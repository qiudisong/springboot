package com.example.demo.controller;

import com.example.demo.config.Exception.ParamException;
import com.example.demo.service.ExampleService;
import com.example.demo.vo.ExampleVo;
import com.example.demo.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping(value = "/test")
public class ExampleController {
    @Resource
    private ExampleService exampleService;

    @RequestMapping(value = "/restful", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String restful() {
        return "success";
    }

    @RequestMapping(value = "/requestParam", method = {RequestMethod.GET})
    @ResponseBody
    public ResultVo<ExampleVo> requestParam(@RequestParam Integer integer,
                                            @RequestParam String string,
                                            @RequestParam Date date) {
        ExampleVo exampleVo = new ExampleVo()
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        return ResultVo.ok(exampleVo);
    }

    @RequestMapping(value = "/pathVariable/{integer}/{string}/{date}", method = {RequestMethod.GET})
    @ResponseBody
    public ResultVo<ExampleVo> pathVariable(@PathVariable Integer integer,
                                            @PathVariable String string,
                                            @PathVariable Date date) {
        ExampleVo exampleVo = new ExampleVo()
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        return ResultVo.ok(exampleVo);
    }

    @RequestMapping(value = "/requestBody", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo<ExampleVo> requestBody(@RequestBody ExampleVo exampleVo) {
        exampleVo.setDate(new Date());
        return ResultVo.ok(exampleVo);
    }

    @RequestMapping(value = "html", method = {RequestMethod.POST, RequestMethod.GET})
    public String html() {
        return "/index.html";
    }

    @RequestMapping(value = "jsp", method = {RequestMethod.POST, RequestMethod.GET})
    public String jsp() {
        return "/index.jsp";
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo<ExampleVo> selectByPrimaryKey(@RequestParam int id) {
        return ResultVo.ok(exampleService.selectByPrimaryKey(id));
    }
}
