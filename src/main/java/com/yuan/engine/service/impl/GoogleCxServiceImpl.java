package com.yuan.engine.service.impl;

import com.yuan.engine.dao.GoogleCxDao;
import com.yuan.engine.entity.GoogleCx;
import com.yuan.engine.service.GoogleCxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yuanjp on 2017/6/14 0014.
 */
@Service("googleCxService")
public class GoogleCxServiceImpl implements GoogleCxService{

    @Autowired
    private GoogleCxDao googleCxDao;

    @Override
    public List<GoogleCx> queryAll() {
        return googleCxDao.queryAll();
    }
}
