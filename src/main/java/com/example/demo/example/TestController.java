package com.example.demo.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/restful", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String restful() {
        return "success";
    }

    @RequestMapping(value = "/requestParam", method = {RequestMethod.GET})
    @ResponseBody
    public TestVo requestParam(@RequestParam Integer integer,
                               @RequestParam String string,
                               @RequestParam Date date) {
        TestVo testVo = new TestVo()
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        return testVo;
    }

    @RequestMapping(value = "/pathVariable/{integer}/{string}/{date}", method = {RequestMethod.GET})
    @ResponseBody
    public TestVo pathVariable(@PathVariable Integer integer,
                               @PathVariable String string,
                               @PathVariable Date date) {
        TestVo testVo = new TestVo()
                .setInteger(integer)
                .setString(string)
                .setDate(date);
        return testVo;
    }

    @RequestMapping(value = "/requestBody", method = {RequestMethod.POST})
    @ResponseBody
    public TestVo requestBody(@RequestBody TestVo testVo) {
        testVo.setDate(new Date());
        return testVo;
    }

    @RequestMapping(value = "html", method = {RequestMethod.POST, RequestMethod.GET})
    public String html() {
        return "/index.html";
    }

    @RequestMapping(value = "jsp", method = {RequestMethod.POST, RequestMethod.GET})
    public String jsp() {
        return "/index.jsp";
    }
}
