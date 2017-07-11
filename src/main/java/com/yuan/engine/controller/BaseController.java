package com.yuan.engine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统全局控制类
 * Created by Yuanjp on 2017/6/16 0016.
 */

public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

   /* @RequestMapping(value="/")
    public String index(){

        return "index";
    }
*/
}
