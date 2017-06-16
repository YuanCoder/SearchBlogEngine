package com.yuan.engine.controller;

import com.yuan.engine.entity.GoogleCx;
import com.yuan.engine.service.BlogYunService;
import com.yuan.engine.service.GoogleCxService;
import com.yuan.engine.utils.R;
import com.yuan.engine.utils.StringUtils;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuanjp on 2017/6/14 0014.
 */
@RestController
public class IndexController extends BaseController{

    @Resource
    private BlogYunService blogYunService;

    @Resource
    private GoogleCxService googleCxService;

    public static List<GoogleCx> urlList = new ArrayList<GoogleCx>();
    {

    }
    @PostMapping("/search/{p}")
    public R searchByKeyWord(@PathVariable("p") String keyWord, String start){
        urlList=googleCxService.queryAll();
       if(StringUtils.isEmpty(start)){
           start="0";
       }
        return blogYunService.search(keyWord,start,urlList);
    }
}
