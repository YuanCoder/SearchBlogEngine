package com.yuan.engine.service;

import com.yuan.engine.entity.GoogleCx;
import com.yuan.engine.utils.R;

import java.util.List;
import java.util.Objects;

/**
 * Created by Yuanjp on 2017/6/14 0014.
 */
public interface BlogYunService {
    /**
     * 根据指定查询关键字搜索
     * @param q
     * @param start
     * @return
     */
    public R search(String q, String start, List<GoogleCx> urlList);
}
