package com.example.demo.service.impl;

import com.example.demo.dao.ExampleDao;
import com.example.demo.po.ExamplePo;
import com.example.demo.service.ExampleService;
import com.example.demo.vo.ExampleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Resource
    ExampleDao exampleDao;

    @Override
    public ExampleVo selectByPrimaryKey(int id) {
        ExamplePo examplePo = exampleDao.selectByPrimaryKey(id);
        ExampleVo exampleVo1 = null;
        if(examplePo!=null){
            exampleVo1 = new ExampleVo();
            BeanUtils.copyProperties(examplePo,exampleVo1);
        }

        return exampleVo1;
    }
}
