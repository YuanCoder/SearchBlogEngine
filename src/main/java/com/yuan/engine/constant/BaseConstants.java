package com.yuan.engine.constant;

/**
 * 封装系统常用常量 管理类
 * Created by Yuanjp on 2017/6/15 0015.
 */
public interface BaseConstants {
    /**
     * 报文有用参数
     */
    public static final String  RESULTS="results";
    public static final String  TITLE="title";
    public static final String  CONTENT="content";
    public static final String  UNESCAPEDURL="unescapedUrl";

    /**
     * google url 参数
     */
    public static final String  GOOGLEAPI_URL_A="https://www.googleapis.com/customsearch/v1element?key=AIzaSyCVAXiUzRYsML1Pv6RwSG1gunmMikTzQqY&rsz=filtered_cse&num=10&hl=en&prettyPrint=false&source=gcsc&gss=.com&sig=584853a42cc2f90f5533642697d97114&start=";
    public static final String  GOOGLEAPI_URL_B="&cx=";
    public static final String  GOOGLEAPI_URL_C="&q=";
    public static final String  GOOGLEAPI_URL_D="&sort=&googlehost=www.google.com";

    /**
     * 系统返回 参数
     */
    public static final String  CODE="code";
    public static final String  MSG_KEY="msg";
    public static final String  DATA="data";
    public static final String  MSG_VALUE_A="未知异常!";
}
