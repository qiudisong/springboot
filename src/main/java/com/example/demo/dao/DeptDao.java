package com.example.demo.dao;

import com.example.demo.po.DeptPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao {
    void move(int id, int parentId);

    List<DeptPo> selectAll();
}
