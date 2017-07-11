package com.yuan.engine.controller;/**
 * Created by Yuanjp on 2017/7/11 0011.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面控制器
 *
 * @author Yuanjp
 * @create 2017-07-11-11:04
 */
@Controller
public class PageController extends BaseController{

    @RequestMapping("/")
    public String page(){
        return "index";
    }

    @RequestMapping("/index2")
    public String page2(){
        return "index2";
    }
}
