package com.example.demo.controller;

import com.example.demo.result.ResultEnum;
import com.example.demo.result.ResultException;
import com.example.demo.result.ResultVo;
import com.example.demo.service.DeptService;
import com.example.demo.service.ExampleService;
import com.example.demo.vo.ExampleVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping(value = "/dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/move", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo<ExampleVo> move(@RequestParam int id, @RequestParam int parentId) {
        deptService.move(id, parentId);
        ResultVo resultVo = ResultVo.ok();
        return resultVo;
    }
}
