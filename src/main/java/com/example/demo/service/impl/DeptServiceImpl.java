package com.example.demo.service.impl;

import com.example.demo.dao.DeptDao;
import com.example.demo.dao.ExampleDao;
import com.example.demo.po.DeptPo;
import com.example.demo.po.ExamplePo;
import com.example.demo.result.ResultEnum;
import com.example.demo.result.ResultException;
import com.example.demo.service.DeptService;
import com.example.demo.service.ExampleService;
import com.example.demo.vo.ExampleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    DeptDao deptDao;

    @Override
    public void move(int sourceId, int targetId) {
        List<DeptPo> listOfDeptPo = deptDao.selectAll();
        Map<Integer, Integer> relation = listOfDeptPo.stream().collect(Collectors.toMap(DeptPo::getId, DeptPo::getParentId));
        Integer parentId = targetId;
        do {
            if (sourceId == parentId) {
                throw new ResultException(ResultEnum.PARAM_ERROR.setDetailMessage("sourceId不能是targetId本身或上级"));
            }
            parentId = relation.get(parentId);
        } while (parentId != null);
        deptDao.move(sourceId, targetId);
    }
}
