package com.yuan.engine.dao;

import com.yuan.engine.entity.GoogleCx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Yuanjp on 2017/6/14 0014.
 */
@Mapper
public interface GoogleCxDao {

    public List<GoogleCx> queryAll();
}
