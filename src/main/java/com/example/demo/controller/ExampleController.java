package com.example.demo.controller;

import com.example.demo.service.ExampleService;
import com.example.demo.vo.ExampleVo;
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
    public ExampleVo requestParam(@RequestParam Integer integer,
                                  @RequestParam String string,
                                  @RequestParam Date date) {
        ExampleVo exampleVo = new ExampleVo()
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        return exampleVo;
    }

    @RequestMapping(value = "/pathVariable/{integer}/{string}/{date}", method = {RequestMethod.GET})
    @ResponseBody
    public ExampleVo pathVariable(@PathVariable Integer integer,
                                  @PathVariable String string,
                                  @PathVariable Date date) {
        ExampleVo exampleVo = new ExampleVo()
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        return exampleVo;
    }

    @RequestMapping(value = "/requestBody", method = {RequestMethod.POST})
    @ResponseBody
    public ExampleVo requestBody(@RequestBody ExampleVo exampleVo) {
        exampleVo.setDate(new Date());
        return exampleVo;
    }

    @RequestMapping(value = "html", method = {RequestMethod.POST, RequestMethod.GET})
    public String html() {
        return "/index.html";
    }

    @RequestMapping(value = "jsp", method = {RequestMethod.POST, RequestMethod.GET})
    public String jsp() {
        return "/index.jsp";
    }

    @RequestMapping(value = "/select", method = {RequestMethod.POST})
    @ResponseBody
    public ExampleVo select(@RequestParam int id) {
        return exampleService.select(id);
    }
}
