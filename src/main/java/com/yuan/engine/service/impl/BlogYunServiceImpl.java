package com.yuan.engine.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuan.engine.constant.ConstantParams;
import com.yuan.engine.constant.BaseParams;
import com.yuan.engine.entity.GoogleCx;
import com.yuan.engine.entity.HitBlog;
import com.yuan.engine.service.BlogYunService;
import com.yuan.engine.utils.HttpClientUtil;
import com.yuan.engine.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

        GoogleCx googleCx=urlList.get(index);
        logger.info("urlList="+urlList.toString());
        boolean flag=true;
        for(int i=1;i<=4;i++){
            index=index%urlList.size(); // 计算索引
            try {
                hitBlogList=trySearch(googleCx,q,start);
                logger.info("index="+index+"  engineName="+googleCx.getEngineName()+"执行成功！");
                break;
            } catch (Exception e) {
                logger.info("index="+index+"出现异常！" +e);
                if(i==4){
                    flag=false;
                }
                index++;
                continue;
            }
        }
        if(!flag){ // 4次请求都失败
            return R.error("服务器忙，请过几秒再试！");
        }else if(hitBlogList.size()==0){ // 未查询到结果
            return R.error("未查询到结果，请换个关键字！");
        }else{ // 有结果
            return R.ok().put(hitBlogList);
        }
    }

    /**
     * 查询
     * @param googleCx
     * @param q
     * @param start
     * @return
     */
    private List<HitBlog>  trySearch(GoogleCx googleCx, String q, String start)throws Exception{
        q= URLEncoder.encode(q, "utf-8");
        String urlStr= ConstantParams.getGoogleApiUrl(start,googleCx.getKey(),q);
        logger.info(urlStr);
        HttpClientUtil httpClient=HttpClientUtil.getInstance();
        StringBuffer sb=new StringBuffer(httpClient.sendHttpGet(urlStr));
        logger.info(sb.toString());
        JSONArray r=new JSONArray();
        JSONObject jsonObject=JSONObject.parseObject(sb.toString());
        JSONArray results=jsonObject.getJSONArray(BaseParams.RESULTS);
        List<HitBlog> hitBlogList=new ArrayList<HitBlog>();
        for(int i=0;i<results.size();i++){

            JSONObject j=(JSONObject) results.get(i);
            HitBlog hitBlog=new HitBlog();
            hitBlog.setTitle(j.get(BaseParams.TITLE).toString());
            hitBlog.setContent(j.get(BaseParams.CONTENT).toString());
            hitBlog.setUnescapedUrl(j.get(BaseParams.UNESCAPEDURL).toString());
            hitBlogList.add(hitBlog);
        }
        return hitBlogList;
    }
}
