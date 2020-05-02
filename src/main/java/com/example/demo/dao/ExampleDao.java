package com.example.demo.dao;

import com.example.demo.po.ExamplePo;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleDao {
    ExamplePo selectByPrimaryKey(int id);
}
