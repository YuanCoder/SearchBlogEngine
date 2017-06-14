package com.yuan.engine.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuan.engine.service.BlogYun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class BlogYunImpl implements BlogYun {
    protected Logger logger= LoggerFactory.getLogger(getClass());
    public static List<String> urlList = new ArrayList<String>();

    int index=0;
    {
        BufferedReader urlReader = new BufferedReader(new InputStreamReader(BlogYunImpl.class.getResourceAsStream("/url.txt")));
        String url = "";
        try {
            while((url = urlReader.readLine()) != null) {
                urlList.add(url);
                logger.info(url);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String search(String q, String start) {
        index=index%urlList.size(); // 计算索引
        JSONArray r=null;
        boolean flag=true;
        for(int i=1;i<=4;i++){
            try {
                r=trySearch(urlList.get(index),q,start);
                logger.info("index="+index+"执行成功！");
                break;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.info("index="+index+"出现异常！");
                if(i==3){
                    flag=false;
                }
                index++;
                continue;
            }
        }
        JSONObject result=new JSONObject();
        if(!flag){ // 4次请求都失败
            result.put("success", false);
            result.put("errorInfo", "服务器忙，请过几秒再试！");
        }else if(r.size()==0){ // 未查询到结果
            result.put("success", false);
            result.put("errorInfo", "未查询到结果，请换个关键字！");
        }else{ // 有结果
            result.put("success", true);
            result.put("rows", r);
        }
        return result.toString();
    }

    /**
     * 查询
     * @param cx
     * @param query
     * @param start
     * @return
     */
    private JSONArray trySearch(String cx, String query, String start)throws Exception{
        query= URLEncoder.encode(query, "utf-8");
        String urlStr="https://www.googleapis.com/customsearch/v1element?key=AIzaSyCVAXiUzRYsML1Pv6RwSG1gunmMikTzQqY&rsz=filtered_cse&num=10&hl=en&prettyPrint=false&source=gcsc&gss=.com&sig=584853a42cc2f90f5533642697d97114&start="+start+"&cx="+cx+"&q="+query+"&sort=&googlehost=www.google.com";
        URL url = new URL(urlStr);
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new BufferedInputStream(url.openStream()),"utf-8"));
        String line;
        StringBuffer sb=new StringBuffer();
        while((line = bufr.readLine())!=null){
            sb.append(line);
        }
        bufr.close();
        JSONArray r=new JSONArray();
        JSONObject jsonObject=JSONObject.fromObject(sb.toString());
        JSONArray results=jsonObject.getJSONArray("results");
        for(int i=0;i<results.size();i++){
            JSONObject j=(JSONObject) results.get(i);
            JSONObject o=new JSONObject();
            o.put("title", j.get("title"));
            o.put("content", j.get("content"));
            o.put("unescapedUrl", j.get("unescapedUrl"));
            r.add(o);
        }
        return r;
    }
}
