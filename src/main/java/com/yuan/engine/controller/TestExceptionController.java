package com.yuan.engine.controller;/**
 * Created by Administrator on 2017/6/16 0016.
 */

import com.yuan.engine.exception.BaseException;
import com.yuan.engine.exception.CURDException;
import com.yuan.engine.exception.ConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 异常测试类
 *
 * @author Administrator
 * @create 2017-06-16-15:05
 */
@RestController
public class TestExceptionController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/ex1")
    public Object throwBaseException() throws Exception {
        throw new BaseException("This is BaseException.");
    }

    @RequestMapping("/ex2")
    public Object ConnectionException() throws Exception {
        throw new ConnectionException("This is ConnectionException.");
    }

    @RequestMapping("/ex3")
    public Object CURDException() throws Exception {
        throw new CURDException("This is CURDException.");
    }

    @RequestMapping("/ex4")
    public Object throwIOException() throws Exception {
        throw new IOException("This is IOException.");
    }

    @RequestMapping("/ex5")
    public Object throwNullPointerException() throws Exception {
        throw new NullPointerException("This is NullPointerException.");
    }

    @ExceptionHandler(NullPointerException.class)
    public String controllerExceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("---ControllerException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return e.getMessage();
    }
}
