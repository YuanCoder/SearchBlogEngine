package com.yuan.engine.controller;

import com.yuan.engine.exception.BaseException;
import com.yuan.engine.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统全局异常处理类
 *
 * 同一个异常被局部范围异常处理器和全局范围异常处理器同时覆盖，会选择小范围的局部范围处理器
 * 同一个异常被小范围的异常类和大范围的异常处理器同时覆盖，会选择小范围的异常处理器
 *
 * Created by Yuanjp on 2017/6/16 0016.
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger= LoggerFactory.getLogger(getClass());

    /**
     * 处理具体异常(自定义)
     * 捕获BaseException和其子异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public R baseErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("--BaseException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return R.error(e.getMessage());
    }

    /**
     * 处理一般异常
     * 捕获Exception和其子异常和其所用子异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("--DefaultException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return R.error(e.getMessage());
    }

}
