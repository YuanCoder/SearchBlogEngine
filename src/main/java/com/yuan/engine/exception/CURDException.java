package com.yuan.engine.exception;/**
 * Created by Administrator on 2017/6/16 0016.
 */

/**
 * 数据持久化操作异常
 *
 * @author Administrator
 * @create 2017-06-16-13:46
 */
public class CURDException extends BaseException{

    public CURDException(String message) {
        super(message);
    }
}
