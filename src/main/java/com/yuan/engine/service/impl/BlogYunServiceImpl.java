package com.yuan.engine.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuan.engine.entity.GoogleCx;
import com.yuan.engine.entity.HitBlog;
import com.yuan.engine.service.BlogYunService;
import com.yuan.engine.service.GoogleCxService;
import com.yuan.engine.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuanjp on 2017/6/14 0014.
 */
@Service("blogYunService")
public class BlogYunServiceImpl implements BlogYunService {



    protected Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public R search(String q, String start ,List<GoogleCx> urlList) {
        int index=0;
        List<HitBlog> hitBlogList=new ArrayList<HitBlog>();
        index=index%urlList.size(); // 计算索引
        JSONArray r=null;
        boolean flag=true;
        for(int i=1;i<=4;i++){
            try {
                hitBlogList=trySearch(urlList.get(index).getKey(),q,start);
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
        if(!flag){ // 4次请求都失败
            return R.error("服务器忙，请过几秒再试！");
        }else if(r.size()==0){ // 未查询到结果
            return R.error("未查询到结果，请换个关键字！");
        }else{ // 有结果
            return R.ok().put(hitBlogList);
        }
    }

    /**
     * 查询
     * @param cx
     * @param query
     * @param start
     * @return
     */
    private List<HitBlog>  trySearch(String cx, String query, String start)throws Exception{
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
        JSONObject jsonObject=JSONObject.parseObject(sb.toString());
        JSONArray results=jsonObject.getJSONArray("results");
        List<HitBlog> hitBlogList=new ArrayList<HitBlog>();
        for(int i=0;i<results.size();i++){

            JSONObject j=(JSONObject) results.get(i);
            JSONObject o=new JSONObject();
            HitBlog hitBlog=new HitBlog();
            hitBlog.setTitle(j.get("title").toString());
            hitBlog.setContent(j.get("content").toString());
            hitBlog.setUnescapedUrl(j.get("unescapedUrl").toString());
            hitBlogList.add(hitBlog);
        }
        return hitBlogList;
    }
}
