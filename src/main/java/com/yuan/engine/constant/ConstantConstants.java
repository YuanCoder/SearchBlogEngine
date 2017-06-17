package com.yuan.engine.constant;

/**
 * Created by Yuanjp on 2017/6/15 0015.
 */
public class ConstantConstants implements BaseConstants {

    public static String getGoogleApiUrl(String start, String cx,String q){
        return GOOGLEAPI_URL_A+start+GOOGLEAPI_URL_B+cx+GOOGLEAPI_URL_C+q+GOOGLEAPI_URL_D;
    }
}
